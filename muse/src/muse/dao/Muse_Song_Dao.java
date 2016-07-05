package muse.dao;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import muse.entities.Muse_Song;
public class Muse_Song_Dao {

	
	private DataSource dataSource;

	@PersistenceContext
	private EntityManager entityManager;
	
	
	private void save() {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Muse_Song muse_song = new Muse_Song();
			//set fields here
			entityManager.persist(muse_song);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public Muse_Song findById(Long song_id) {
		try {
			Muse_Song muse_song = entityManager.find(Muse_Song.class, song_id);
			return muse_song;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Muse_Song findByTitle(String song_title) {
		try {
			Muse_Song muse_song = entityManager.find(Muse_Song.class, song_title);
			return muse_song;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
//	@Override
//	public Collection<?> getForParticipantIdAndUsernameAndPassword(BigDecimal pParticipantId, String pUserName,
//			String pPassword) {
//		try {
//			Query query = entityManager.createQuery("SELECT OBJECT(e) " + "FROM ParticipantUser e "
//					+ "WHERE e.participantId = ?" + " AND e.userName = ?" + " AND e.password = ?");
//			query.setParameter(1, pParticipantId);
//			query.setParameter(2, pUserName);
//			query.setParameter(3, pPassword);
//			return query.getResultList();
//		} catch (RuntimeException re) {
//			throw re;
//		}
//	}
	
	
	
	
	
	
//	@NamedQuery(name = "ConfigEditorFile.checkExistenceOfFileRecord", query = "SELECT count(c.fileName) from ConfigEditorFile c where c.filePath = :filePath") })
	
	private boolean originalAlreadySaved(String filePath) {
		boolean originalSaved = false;
		try{
			Long count = (Long) entityManager.createNamedQuery("ConfigEditorFile.checkExistenceOfFileRecord").setParameter("filePath", filePath).getSingleResult();
			if(count>0){
				originalSaved=true;
//				action="Update";//since original already exist, change action to update instead of insert
			}
		}
		catch(NoResultException e){
			return originalSaved;
		}
		catch(NonUniqueResultException e){
			return originalSaved;
		}
		catch(PersistenceException ex){
			return originalSaved;
		}
		return originalSaved;
	}
	
//	 /**
//     * Create new data access object with data source.
//     */
//    public PersonDAO(DataSource newDataSource) throws SQLException {
//        setDataSource(newDataSource);
//    }
//    
//    /**
//     * Get data source which is used for the database operations.
//     */
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//    
//    /**
//     * Set data source to be used for the database operations.
//     */
//    public void setDataSource(DataSource newDataSource) throws SQLException {
//        this.dataSource = newDataSource;
//        checkTable();
//    }
//    
//    /**
//     * Add a person to the table.
//     */
//    public void addPerson(Person person) throws SQLException {
//        Connection connection = dataSource.getConnection();
//
//        try {
//            PreparedStatement pstmt = connection
//                    .prepareStatement("INSERT INTO PERSONS (ID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)");
//            pstmt.setString(1, UUID.randomUUID().toString());
//            pstmt.setString(2, person.getFirstName());
//            pstmt.setString(3, person.getLastName());
//            pstmt.executeUpdate();
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//
//    /**
//     * Get all persons from the table.
//     */
//    public List<Person> selectAllPersons() throws SQLException {
//        Connection connection = dataSource.getConnection();
//        try {
//            PreparedStatement pstmt = connection
//                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME FROM PERSONS");
//            ResultSet rs = pstmt.executeQuery();
//            ArrayList<Person> list = new ArrayList<Person>();
//            while (rs.next()) {
//                Person p = new Person();
//                p.setId(rs.getString(1));
//                p.setFirstName(rs.getString(2));
//                p.setLastName(rs.getString(3));
//                list.add(p);
//            }
//            return list;
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//
//    /**
//     * Check if the person table already exists and create it if not.
//     */
//    private void checkTable() throws SQLException {
//        Connection connection = null;
//
//        try {
//            connection = dataSource.getConnection();
//            if (!existsTable(connection)) {
//                createTable(connection);
//            }
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//
//    /**
//     * Check if the person table already exists.
//     */
//    private boolean existsTable(Connection conn) throws SQLException {
//        DatabaseMetaData meta = conn.getMetaData();
//        ResultSet rs = meta.getTables(null, null, "PERSONS", null);
//        while (rs.next()) {
//            String name = rs.getString("TABLE_NAME");
//            if (name.equals("PERSONS")) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Create the person table.
//     */
//    private void createTable(Connection connection) throws SQLException {
//        PreparedStatement pstmt = connection
//                .prepareStatement("CREATE TABLE PERSONS "
//                        + "(ID VARCHAR(255) PRIMARY KEY, "
//                        + "FIRSTNAME VARCHAR (255),"
//                        + "LASTNAME VARCHAR (255))");
//        pstmt.executeUpdate();
//    }

}
