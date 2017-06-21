package com.diary.model;
/**
 * �ۤ��A����ק�A�i�H�R���C*/
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhotoJDBCDAO implements PhotoDAO_interface{
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ba101g3";
	private static final String PASSWORD = "baby";
	
	private static final String INSERT_STMT = 
			"INSERT INTO photo (pho_no, baby_no, pho_title, pho_date, pho_annot, pho_file, pho_shr) VALUES ('PHO'||LPAD(to_char(pho_no_seq.NEXTVAL), 5, '0'), ?, ?, SYSDATE, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM photo";
	private static final String GET_ONE_STMT = 
			"SELECT * FROM photo WHERE pho_no = ?";
	private static final String DELETE_PHOTO = "DELETE FROM photo WHERE pho_no = ?";
	
	
	@Override
	public void insert(PhotoVO photoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, photoVO.getBaby_no());
			pstmt.setString(2, photoVO.getPho_title());
			pstmt.setString(3, photoVO.getPho_annot());
			pstmt.setBytes(4, photoVO.getPho_file());
			pstmt.setString(5, photoVO.getPho_shr());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(String pho_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_PHOTO);

			pstmt.setString(1, pho_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public PhotoVO findByPrimary(String pho_no) {
		PhotoVO photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, pho_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				photoVO = new PhotoVO();
				photoVO.setPho_no(rs.getString("pho_no"));
				photoVO.setBaby_no(rs.getString("baby_no"));
				photoVO.setPho_title(rs.getString("pho_title"));
				photoVO.setPho_date(rs.getTimestamp("pho_date"));
				photoVO.setPho_annot(rs.getString("pho_annot"));
				photoVO.setPho_file(rs.getBytes("pho_file"));
				photoVO.setPho_shr(rs.getString("pho_shr"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
		return photoVO;
	}

	@Override
	public List<PhotoVO> getAll() {
		List<PhotoVO> list = new ArrayList<PhotoVO>();
		PhotoVO photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				photoVO = new PhotoVO();
				photoVO.setPho_no(rs.getString("pho_no"));
				photoVO.setBaby_no(rs.getString("baby_no"));
				photoVO.setPho_title(rs.getString("pho_title"));
				photoVO.setPho_date(rs.getTimestamp("pho_date"));
				photoVO.setPho_annot(rs.getString("pho_annot"));
				photoVO.setPho_file(rs.getBytes("pho_file"));
				photoVO.setPho_shr(rs.getString("pho_shr"));
				list.add(photoVO);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
		return list;
	}
	
	public static void main(String[] args){
		PhotoJDBCDAO dao= new PhotoJDBCDAO();
		// �s�W OK
//		PhotoVO photoVO1 = new PhotoVO();
//		photoVO1.setBaby_no("BABY0002");
//		photoVO1.setPho_annot("�Y���P");
//		photoVO1.setPho_shr("0");
//		byte[] pic;
//		try {
//			pic = getPictureByteArray("WebContent/images/1B.png");
//			photoVO1.setPho_file(pic);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		dao.insert(photoVO1);
//		System.out.println("�s�W��Ƨ���");
		
		

		// �R�� OK
//		dao.delete("PHO00002");
//		System.out.print("��ƧR������");
		
		// �d�߳浧 OK
//		PhotoVO photoVO3 = dao.findByPrimary("PHO00002");
//		System.out.print(photoVO3.getPho_no() + ",");
//		System.out.print(photoVO3.getBaby_no() + ",");
//		System.out.print(photoVO3.getPho_title() + ",");
//		System.out.print(photoVO3.getPho_date() + ",");
//		System.out.print(photoVO3.getPho_annot() + ",");
//		System.out.print(photoVO3.getPho_file() + ",");
//		System.out.println(photoVO3.getPho_shr());
//		System.out.println("---------------------");
		
		// �d�ߥ��� OK
		List<PhotoVO> list = dao.getAll();
		for (PhotoVO photoVO : list) {
			System.out.print(photoVO.getPho_no() + ",");
			System.out.print(photoVO.getBaby_no() + ",");
			System.out.print(photoVO.getPho_title() + ",");
			System.out.print(photoVO.getPho_date() + ",");
			System.out.print(photoVO.getPho_annot() + ",");
			System.out.print(photoVO.getPho_file() + ",");
			System.out.print(photoVO.getPho_shr());
			System.out.println();
		}
	}
	public static byte[] getPictureByteArray(String path) throws IOException {
		//�s�W�@��file������åB�i�H�����Ƕi�Ӫ����|
		File file = new File(path);
		//�M�����Ƕi�Ӫ�file�e��inputSTream�B�z"�줸�ժ���J�u�@"
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//�B�z8192byte�����
		byte[] buffer = new byte[8192];
		int i;
		//�Q��read()Ū����@�r��
		//readLine();�O�Ψ�Ū���@��r��
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	
	}
	
}