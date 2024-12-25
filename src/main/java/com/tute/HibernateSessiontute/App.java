package com.tute.HibernateSessiontute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");  // can use without params if config file present in resources
    	
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student st = new Student();
        st.setCity("Delhi");
        st.setName("Vartul");
        st.setId(102);
        
        Address ad = new Address();
        
        ad.setStreet("Street 1");
        ad.setCity("Haryana");
        ad.setOpen(true);
        ad.setAddedData(LocalDate.now());
        
        // reading image
        byte[] data = new byte[0];
        
        String filePath = "src/main/java/unnamed.jpg";  // Path to your image file

        try {
            // Read the image file into a byte array
            data = Files.readAllBytes(Paths.get(filePath));
            System.out.println("Read " + data.length + " bytes from the file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ad.setImage(data);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(st);
        session.persist(ad);
        
        tx.commit();
        
        session.close();
        
    }
}
