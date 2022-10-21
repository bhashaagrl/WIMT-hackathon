import java.util.List;

public class ExecuteCommands {

	public static String errorMsg = "Incomplete information to execute current command. ";
	public static String transferMsg = "Sample command: Transfer $500 from Allen Smith savings account to brokerage account." ;
	public static String balanceMsg = "Sample command: What is the balance of Allen Smith savings account." ;
	public static String profileMsg = "Sample command: Open Allen Smith profile in client management." ;
	public static String noteMsg = "Sample command: Add a note to Allen Smith as \"\"" ;
	public static String holdMsg = "Sample command: Add a hold recommendation to Allen Smith trade account as xxx";
	
	
	public void decideAction(List<String> al) {
		if(al.contains("transfer")) {
			System.out.println(initiateTransfer(al));
		}
		else if(al.contains("balance")) {
			System.out.println(showBalance(al));
		}
		else if(al.contains("profile")) {
			System.out.println(openProfile(al));
		}
		else if(al.contains("note")) {
			System.out.println(addNote(al));
		}
		else if(al.contains("hold")) {
			System.out.println(holdAccount(al));
		}
		else {
			System.out.println("No valid command found");
		}
	}
	
	public static String initiateTransfer(List<String> al) {
		String response = "";
		int indF = al.indexOf("from");
		int indT = al.indexOf("to");
		String sender = null;
		String receiver = null;
		if(indF>-1 && indT>-1) {
			try {
				sender = al.get(indF+1);
				receiver = al.get(indT+1);
				if(sender.isEmpty() || sender.equals("to") || receiver.isEmpty()) {
					return errorMsg + transferMsg;
				}
				else {
					response = "Transfer successful";
				}
			}catch (Exception e) {
				return errorMsg + transferMsg;
			}
		}else {
			return errorMsg + transferMsg;
		}
		return response;
	}
	
	public static String showBalance(List<String> al) {
		String response = "";
		int indB = al.indexOf("balance");
		String balAcc = null;
		if(indB >-1) {
			try {
			balAcc = al.get(indB+2);
			if(balAcc.isEmpty()) {
				return errorMsg + balanceMsg;
			}
			else {
				response = "Balance displayed";
			}
			}catch (Exception e) {
				return errorMsg + balanceMsg;
			}
		}else {
			return errorMsg + balanceMsg;
		}
		return response;
	}
	
	public static String openProfile(List<String> al) {
		String response = "";
		int indB = al.indexOf("profile");
		String profileAcc = null;
		if(indB >-1) {
			try {
			profileAcc = al.get(indB+2);
			if(profileAcc.isEmpty()) {
				return errorMsg + profileMsg;
			}
			else {
				response = "Profile opened";
			}
			}catch (Exception e) {
				return errorMsg + profileMsg;
			}
		}else {
			return errorMsg + profileMsg;
		}
		return response;
	}
	
	public static String addNote(List<String> al) {
		String response = "";
		int indB = al.indexOf("as");
		String noteAcc = null;
		if(indB >-1) {
			try {
			noteAcc = al.get(indB+1);
			if(noteAcc.isEmpty()) {
				return errorMsg + noteMsg;
			}
			else {
				response = "Note added";
			}
			}catch (Exception e) {
				return errorMsg + noteMsg;
			}
		}else {
			return errorMsg + noteMsg;
		}
		return response;
	}
	
	public static String holdAccount(List<String> al) {
		String response = "";
		int indB = al.indexOf("hold");
		String holdAcc = null;
		if(indB >-1) {
			try {
			holdAcc = al.get(indB+1);
			if(holdAcc.isEmpty()) {
				return errorMsg + holdMsg;
			}
			else {
				response = "Hold recommendation added";
			}
			}catch (Exception e) {
				return errorMsg + holdMsg;
			}
		}else {
			return errorMsg + holdMsg;
		}
		return response;
	}

}
