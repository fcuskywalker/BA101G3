package com.admin.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.admin.model.*;

@WebServlet("/AuthorityFeatureServlet.do")
public class AuthorityFeatureServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        // �Ӧ�select_page.jsp���ШD                                  // �Ӧ� dept/listAllDept.jsp���ШD
        if ("listAFs_ByAuth_No_A".equals(action) || "listAFs_ByAuth_No_B".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                /*************************** 1.�����ШD�Ѽ� ****************************************/
                String auth_no = new String(req.getParameter("auth_no"));

                /*************************** 2.�}�l�d�߸�� ****************************************/
                Authority_FeatureService authority_FeatureSvc = new Authority_FeatureService();
                Authority_FeatureVO authority_FeatureVO = authority_FeatureSvc.getOneAF(auth_no);

                /*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
                req.setAttribute("listAFs_ByAuth_No", authority_FeatureVO);    // ��Ʈw���X��list����,�s�Jrequest

                String url = null;
                if ("listAFs_ByAuth_No_A".equals(action))
                    url = "/AuthorityFeature/listEmps_ByDeptno.jsp";        // ���\��� dept/listEmps_ByDeptno.jsp
                else if ("listAFs_ByAuth_No_B".equals(action))
                    url = "/AuthorityFeature/listAllAF.jsp";              // ���\��� dept/listAllAF.jsp

                RequestDispatcher successView = req.getRequestDispatcher(url);
                successView.forward(req, res);

                /*************************** ��L�i�઺���~�B�z ***********************************/
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

        /*if ("delete_Dept".equals(action)) {

            List<String> errorMsgs = new LinkedList<String>();
            req.setAttribute("errorMsgs", errorMsgs);

            try {
                *//***************************1.�����ШD�Ѽ�***************************************//*
                String auth_no = new String(req.getParameter("auth_no"));

                *//***************************2.�}�l�R�����***************************************//*
                Authority_FeatureService authority_FeatureSvc = new Authority_FeatureService();
                authority_FeatureSvc.deleteAF(auth_no);

                *//***************************3.�R������,�ǳ����(Send the Success view)***********//*
                String url = "/dept/listAllAF.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��, ���\��� �^�� /dept/listAllAF.jsp
                successView.forward(req, res);

                *//***************************��L�i�઺���~�B�z***********************************//*
            } catch (Exception e) {
                errorMsgs.add("�R����ƥ���:" + e.getMessage());
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/AuthorityFeature/listAllAF.jsp");
                failureView.forward(req, res);
            }
        }*/
    }
}
