package com.admin.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDAO implements AdminDAO_interface {

    // �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
    private static DataSource ds = null;

    static {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDBG3");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // �s�W���
    private static final String INSERT_STMT = "INSERT INTO admin (adm_no, adm_acct, adm_pwd, adm_name, adm_mail) " +
            "VALUES ('ADM'||LPAD(to_char(adm_no_seq.nextval),5,'0'), ?, ?, ?, ?)";
    // �d�߸��
    private static final String GET_ALL_STMT = "SELECT * FROM admin";
    private static final String GET_ONE_STMT = "SELECT * FROM admin WHERE adm_no = ?";
    // �ק���
    private static final String UPDATE = "UPDATE admin SET adm_acct=?, adm_pwd=?, adm_name=?, adm_mail=? WHERE adm_no = ?";


    @Override
    public void insert(AdminVO adminVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = ds.getConnection();
            String[] seq = {"adm_no"}; // ���ϥ�sequence���ͽs�����ܤ~�n�g
            pstmt = con.prepareStatement(INSERT_STMT, seq); // ���ϥ�sequence���ͽs�����ܤ~�n�g�ĤG�ӰѼ�

            pstmt.setString(1, adminVO.getAdm_acct());
            pstmt.setString(2, adminVO.getAdm_pwd());
            pstmt.setString(3, adminVO.getAdm_name());
            pstmt.setString(4, adminVO.getAdm_mail());

            pstmt.executeUpdate();

        } catch (Exception se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public void update(AdminVO adminVO) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, adminVO.getAdm_name());
            pstmt.setString(2, adminVO.getAdm_no());

            pstmt.executeUpdate();

            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public AdminVO findByPrimaryKey(String adm_no) {

        AdminVO adminVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setString(1, adm_no);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                adminVO = new AdminVO();
                adminVO.setAdm_no(rs.getString("adm_no"));
                adminVO.setAdm_acct(rs.getString("adm_acct"));
                adminVO.setAdm_pwd(rs.getString("adm_pwd"));
                adminVO.setAdm_name(rs.getString("adm_name"));
                adminVO.setAdm_mail(rs.getString("adm_mail"));
            }
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return adminVO;
    }

    @Override
    public List<AdminVO> getAll() {

        List<AdminVO> list = new ArrayList<AdminVO>();
        AdminVO adminVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                adminVO = new AdminVO();
                adminVO.setAdm_no(rs.getString("adm_no"));
                adminVO.setAdm_name(rs.getString("adm_name"));
                list.add(adminVO); // Store the row in the list
            }
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return list;
    }
}