
import java.io.UnsupportedEncodingException;

public class HelloWorld {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		byte[] sourceBytes;
	    String strBytes;
	    String character;
	    
	    // 영어 대문자 "A" 인코딩 값
		character = "A";
	    	    
	    sourceBytes = character.getBytes("UTF-8");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("EUC-KR");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("UTF-16");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("CP949");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("ASCII"); 
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    System.out.println();
		
	    // 한글 "가" 인코딩 값
	    character = "가";
   
	    sourceBytes = character.getBytes("UTF-8");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("EUC-KR");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("UTF-16");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("CP949");
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	    
	    sourceBytes = character.getBytes("ASCII"); //잘못된값. 아스키 1byte로는 한글이 표현이 안된다
	    strBytes = HelloWorld.byteArrayToHex(sourceBytes);
	    System.out.println(strBytes);
	}
	
	public static String byteArrayToHex(byte[] a) {  // 16진수 byte값 출력을 위해  byte값 자체를 String으로 변환
	    StringBuilder sb = new StringBuilder();
	    for(final byte b: a)
	        sb.append(String.format("%02x ", b&0xff));
	    return sb.toString();
	}
}