package servlet;

import java.util.Date;

import servlet.StringUtil;



public class Block {

	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.

	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}
}

AES.java;
   package servlet;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class AES 
{
private static String algorithm = "AES";
private static byte[] keyValue=new byte[] 
{ 'A', 'S', 'e', 'c', 'u', 'r', 'e', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

        // Performs Encryption
        public static String encrypt99(String plainText) throws Exception 
        {
                Key key = generateKey();
                Cipher chiper = Cipher.getInstance(algorithm);
                chiper.init(Cipher.ENCRYPT_MODE, key);
                byte[] encVal = chiper.doFinal(plainText.getBytes());
                String encryptedValue = new BASE64Encoder().encode(encVal);
                return encryptedValue;
        }

        // Performs decryption
        public static String decrypt(String encryptedText) throws Exception 
        {
                // generate key 
                Key key = generateKey();
                Cipher chiper = Cipher.getInstance(algorithm);
                chiper.init(Cipher.DECRYPT_MODE, key);
                byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
                byte[] decValue = chiper.doFinal(decordedValue);
                String decryptedValue = new String(decValue);
                return decryptedValue;
        }

//generateKey() is used to generate a secret key for AES algorithm
        private static Key generateKey() throws Exception 
        {
                Key key = new SecretKeySpec(keyValue, algorithm);
                return key;
        }
}

Staffreg.java;
package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.stafregbean;

/**
 * Servlet implementation class staffreg
 */
@WebServlet("/staffreg")
public class staffreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staffreg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		System.out.println("name"+name);
		
		String team=request.getParameter("teams");
		System.out.println("team"+team);
		
		String email=request.getParameter("email");
		System.out.println("email"+email);
		
		String number=request.getParameter("number");
		System.out.println("number"+number);
		
		String pass=request.getParameter("pass");
		System.out.println("pass"+pass);
		
		String cpass=request.getParameter("cpass");
		System.out.println("cpass"+cpass);
		
		stafregbean s=new stafregbean();
		s.setName(name);
		s.setTeam(team);
		s.setEmail(email);
		s.setNumber(number);
		s.setPass(pass);
		s.setCpass(cpass);
		
		inter n=new imple();
		int b=n.reg(s);
		if(b==1){
			response.sendRedirect("stafflogin.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}
}
Dbcon.java;
package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;



public class dbcon {
	static Connection con;
	
	public static Connection create()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/team","root","root");
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return con;
	}}

