package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Massa;

public class MassasDAO {

	public void save(Massa massa) {

		String sql = "insert into massas(NAME_PRODUCT,CUSTOMIZATION,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE,MEMORY,OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT,COLOR) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.criarConeccaoComMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, massa.getNameProduct());
			pstm.setString(2, massa.getCustomization());
			pstm.setString(3, massa.getDisplay());
			pstm.setString(4, massa.getDisplayResolution());
			pstm.setString(5, massa.getDisplaySize());
			pstm.setString(6, massa.getMemory());
			pstm.setString(7, massa.getOperatingSystem());
			pstm.setString(8, massa.getProcessor());
			pstm.setString(9, massa.getTouchscreen());
			pstm.setString(10, massa.getWeight());
			pstm.setString(11, massa.getColor());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<Massa> getMassas() {
		String sql = "SELECT * FROM massas";

		List<Massa> massas = new ArrayList<Massa>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.criarConeccaoComMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Massa massa = new Massa();

				massa.setIdMassas(rset.getInt("IDMASSAS"));
				massa.setNameProduct(rset.getString("NAME_PRODUCT"));
				massa.setCustomization(rset.getString("CUSTOMIZATION"));
				massa.setDisplay(rset.getString("DISPLAY"));
				massa.setDisplayResolution(rset.getString("DISPLAY_RESOLUTION"));
				massa.setDisplaySize(rset.getString("DISPLAY_SIZE"));
				massa.setMemory(rset.getString("MEMORY"));
				massa.setOperatingSystem(rset.getString("OPERATING_SYSTEM"));
				massa.setProcessor(rset.getString("PROCESSOR"));
				massa.setTouchscreen(rset.getString("TOUCHSCREEN"));
				massa.setWeight(rset.getString("WEIGHT"));
				massa.setColor(rset.getString("COLOR"));

				massas.add(massa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return massas;
	}

	public void update(Massa massa) {
		String sql = "UPDATE massas SET name_product = ?, customization = ?,display = ?,display_resolution = ?,display_size = ?,memory = ?,operating_system = ?,processor = ?,touchscreen = ?,weight = ?,color = ? "
				+ "WHERE idmassas = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.criarConeccaoComMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, massa.getNameProduct());
			pstm.setString(2, massa.getCustomization());
			pstm.setString(3, massa.getDisplay());
			pstm.setString(4, massa.getDisplayResolution());
			pstm.setString(5, massa.getDisplaySize());
			pstm.setString(6, massa.getMemory());
			pstm.setString(7, massa.getOperatingSystem());
			pstm.setString(8, massa.getProcessor());
			pstm.setString(9, massa.getTouchscreen());
			pstm.setString(10, massa.getWeight());
			pstm.setString(11, massa.getColor());

			pstm.setInt(12, massa.getIdMassas());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
