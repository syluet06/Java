import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Ping {
	public static void main(String[] args) throws IOException {
		Scanner site = new Scanner(System.in);
    System.out.print("Enter the site you'll search:");
		String site2 = site.next(); 
		long b = System.currentTimeMillis();
		InetAddress ia = InetAddress.getByName(site2);
		System.out.print("Site:" + ia.getHostName() + "\nIP:" + ia.getHostAddress() );
		long a = System.currentTimeMillis();
		System.out.print("\nTime:" + (a-b) + " ms\n");
		
		Ping shell = new Ping();
		System.out.println(ia.isReachable(5000) ? "Host is reachable\n" : "Cannot reach to the host");
		String result = shell.run("dig +short NS " + site2);
		System.out.print(result);
		String result2 = shell.run("dig +short MX " + site2);
		System.out.print("\n" + result2);
	}
	
	public String run(String command) {
	
	StringBuilder sb = new StringBuilder();
	BufferedReader reader = null;
	Process p;
	
	try {
		p = Runtime.getRuntime().exec(command);
		p.waitFor();
		reader = new BufferedReader(
			new InputStreamReader(p.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return sb.toString();
	}
}




