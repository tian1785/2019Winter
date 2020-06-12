package Day08;

import java.security.NoSuchAlgorithmException;

public class BlockChainTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String data[] = {"Genesis Block", "2nd", "3rd"};
		BlockChainMaker maker = new BlockChainMaker(data.length, data);
		
		Block[] result = maker.makingBlock();
		
		for (Block b : result) {
			System.out.println("nonce: "+b.getNonce());
			System.out.println("data: "+b.getData());
			System.out.println("prevhash: "+b.getPrevhash());
			System.out.println("hash: "+b.getHash());
			System.out.println();
		}
	}

}
