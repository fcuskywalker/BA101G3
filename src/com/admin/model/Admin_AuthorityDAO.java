package com.admin.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Admin_AuthorityDAO implements Admin_AuthorityDAO_interface {
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
    private static final String INSERT_STMT = "INSERT INTO admin_authority (adm_no, auth_no) VALUES (?, ?)";
    // �d�߸��
    private static final String GET_ALL_STMT = "SELECT * FROM admin_authority";
    private static final String GET_BY_ADM_NO_STMT = "SELECT * FROM admin_authority WHERE adm_no = ?";
    // �R�����
    private static final String DELETE_ADMIN_AUTHORITY = "DELETE FROM admin_authority WHERE adm_no = ? AND auth_no = ?";

    @Override
    public void insert(Admin_AuthorityVO admin_AuthorityVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = ds.getConnection();

            pstmt = con.prepareStatement(INSERT_STMT);
            pstmt.setString(1, admin_AuthorityVO.getAdm_no());
            pstmt.setString(2, admin_AuthorityVO.getAuth_no());
            pstmt.executeUpdate();

            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
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
    public void delete(String adm_no, String auth_no) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();

            pstmt = con.prepareStatement(DELETE_ADMIN_AUTHORITY);
            pstmt.setString(1, adm_no);
            pstmt.setString(2, auth_no);
            pstmt.executeUpdate();

            System.out.println("Delete Admin Authority:" + adm_no + " and " + auth_no);

            // Handle any SQL errors
        } catch (SQLException se) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException excep) {
                    throw new RuntimeException("rollback error occured. " + excep.getMessage());
                }
            }
            throw new RuntimeException("A database error occured. " + se.getMessage());
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
    public List<Admin_AuthorityVO> findByAdmNo(String adm_no) {

        List<Admin_AuthorityVO> list = new ArrayList<Admin_AuthorityVO>();
        Admin_AuthorityVO admin_authorityVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_BY_ADM_NO_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                admin_authorityVO = new Admin_AuthorityVO();
                admin_authorityVO.setAdm_no(rs.getString("adm_no"));
                admin_authorityVO.setAuth_no(rs.getString("auth_no"));
                list.add(admin_authorityVO); // Store the row in the list
            }
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
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

    @Override
    public List<Admin_AuthorityVO> getAll() {

        List<Admin_AuthorityVO> list = new ArrayList<Admin_AuthorityVO>();
        Admin_AuthorityVO admin_AuthorityVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                admin_AuthorityVO = new Admin_AuthorityVO();
                admin_AuthorityVO.setAdm_no(rs.getString("adm_no"));
                admin_AuthorityVO.setAuth_no(rs.getString("auth_no"));
                list.add(admin_AuthorityVO); // Store the row in the list
            }
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
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