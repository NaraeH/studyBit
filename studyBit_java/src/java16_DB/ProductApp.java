package java16_DB;

public class ProductApp {
	public static void main(String[] args) {
		Products product = new Products();
		try {
			product.conInit();
			product.menu();
		} catch (Exception e) {
		} finally {
			try { product.destroy();} catch (Exception e) {}

		}
	}
}
