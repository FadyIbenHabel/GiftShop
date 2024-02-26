package giftshop;

class Manager extends User {


 public Manager(String userId, String username, String password) {
     super(userId, username, password, "Manager");
 }



 public void generateSalesReport(SalesReportGenerator salesReportGenerator) {
     salesReportGenerator.generateSalesReport();
 }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
