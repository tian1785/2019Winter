package Day08;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockChainMaker {
	int blocksize;
	String[] data;
	
	public BlockChainMaker(int blocksize) {
		this.blocksize = blocksize;
		data = new String[blocksize];
		for(int i=0; i<blocksize; i++) {
			data[i] = ""+i;
		}
	}
	
	public BlockChainMaker(int blocksize, String[] data) {
		this.blocksize = blocksize;
		this.data = data;
	}
	
	public Block[] makingBlock() throws NoSuchAlgorithmException {
		Block[] chains = new Block[blocksize];
		// generating genesis block
		chains[0] = new Block("", data[0]);
		chains[0].setHash(bytesToHex(sha256(chains[0].getNonce() + chains[0].getPrevhash() + data[0])));
		
		
		for(int i=1; i<blocksize; i++) {
			chains[i] = new Block(chains[i-1].getHash(), data[i]);
			
			String tmp = bytesToHex(sha256(chains[i].getNonce() + chains[i].getPrevhash() + data[i]));
			while(!tmp.startsWith("00000")) {
				chains[i].setNonce(chains[i].getNonce().add(BigInteger.ONE));
				tmp = bytesToHex(sha256(chains[i].getNonce() + chains[i].getPrevhash() + data[i]));
			}
			
			chains[i].setHash(tmp);			
		}
		
		return chains;
	}
	
	public static byte[] sha256(String msg) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		
		return md.digest();
	}
	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b: bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
