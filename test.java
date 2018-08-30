/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static final int MAX_CHILD=20;
	static int counter=0;
	static long id=10000000;
	public static void main (String[] args) throws java.lang.Exception
	{
			
	}
	boolean createNewNode(Node parent,Data data,Node gen){
		float sum=0;
		for(int i=0;i<numChild;i++){
			sum=sum+parent.childReferenceNodeId[i].data.getValue();
		}
		sum=sum+data.value;
		if(sum>parent.data.getValue())
		return false;
	    Node newNode=new Node(data);
		parent.childReferenceNodeId[parent.numChild]=newNode;
		parent.genesisReferenceNodeId=gen;
		return true;
	}
	Node createNewGenesisNode(Data data){
		Node newNode=new Node(data);
		return newNode;
	}
	class Data{
		String ownId;
		String value;
		String ownName;
		String hash;
		String key;
		boolean isEncrypted;
		void encryptData(){
			if(!isEncrypted){
			this.ownId=this.ownId^this.key;
			this.value=this.value^this.key;
			this.ownName=this.ownName^this.key;
			this.hash=this.hash^this.key;
			}
		}
		void decryptData(){
			if(isEncrypted){
				this.ownId=this.ownId^this.key;
				this.value=this.value^this.key;
				this.ownName=this.ownName^this.key;
				this.hash=this.hash^this.key;	
			}
		}
		float getValue(){
			if(isEncrypted){
				return Float.parseFloat(this.value^this.key);
			}
			else
			return Float.parseFloat(this.value);
		}
		
	}
	class Node{
		Date timestamp;
		String data;
		int nodeNumber;
		String nodeId;
		int numChild;
		Node referenceNodeId;
		Node childReferenceNodeId[];
		Node genesisReferenceNodeId;
		String HashValue;
		Node(Data data){
			this.data=data;
			this.nodeId=Ideone.id++;
			this.childReferenceNodeId=new Node[Ideone.MAX_CHILD];
			this.genesisReferenceNodeId=null;
			this.nodeNumber=Ideone.counter++;
			this.HashValue="";
			this.timestamp=System.getCurrentTime();
			this.referenceNodeId=null;
			this.numChild=0;
		}
	}
}
	}
}