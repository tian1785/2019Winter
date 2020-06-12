package Day08;

import java.math.BigInteger;

public class Block {
	String prevhash;
	String data;
	String hash;
	BigInteger nonce;
	
	public Block(String prevhash, String data) {
		super();
		this.prevhash = prevhash;
		this.data = data;
		nonce = BigInteger.ONE;
	}

	public String getPrevhash() {
		return prevhash;
	}

	public void setPrevhash(String prevhash) {
		this.prevhash = prevhash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public BigInteger getNonce() {
		return nonce;
	}

	public void setNonce(BigInteger nonce) {
		this.nonce = nonce;
	}
	
}
