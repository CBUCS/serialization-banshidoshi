package com.adt.datastructure;

import java.util.ArrayList;

public class SerializeDeserialize {
        private BinaryTreeNode root;

        private ArrayList<Integer> serializedArray= new ArrayList<Integer>();
        String fileLocation="bst.csv";


        public SerializeDeserialize() {
            root = null;
        }
        public void add(int d){
            BinaryTreeNode newBinaryTreeNode= new BinaryTreeNode();
            newBinaryTreeNode.left=newBinaryTreeNode.right=null;
            newBinaryTreeNode.data=d;
            if(root==null){
                root=newBinaryTreeNode;
                return;
            }
            BinaryTreeNode n=root;
            BinaryTreeNode parent=null;
            while(n!=null){
                parent=n;
                if (n.data==d) return;
                else if(d>n.data) n=n.right;
                else n=n.left;
            }
            if (d>parent.data) parent.right=newBinaryTreeNode;
            else parent.left=newBinaryTreeNode;
        }
        public void preOrderAll(){
            System.out.println("Preorder:");
            preOrder(root);
        }
        public void preOrder(BinaryTreeNode r){
            if(r==null) return;
            System.out.println(r.data);
            preOrder(r.left);
            preOrder(r.right);
        }
        public void serialize() throws Exception{
            preOrderFillArray(root);
            System.out.print("Serialize:");
            for(int i=0;i<serializedArray.size();i++){
                System.out.print(serializedArray.get(i)+" ");
            }
            System.out.println();
            //store the ArrayList in the file
            WriteFile myFile= new WriteFile();
            myFile.writeln(fileLocation, serializedArray);

        }
        private void preOrderFillArray(BinaryTreeNode r){
            if(r==null) return;
            serializedArray.add(r.data);
            preOrderFillArray(r.left);
            preOrderFillArray(r.right);
        }
        public void deSerialize() throws Exception{
            ReadFile myFile = new ReadFile();
            serializedArray = myFile.readln(fileLocation);
            root=null;
            root=deSerializeFromRoot(0,serializedArray.size()-1);

        }
        private BinaryTreeNode deSerializeFromRoot(int low,int high){
            if (low>high) return null;
            BinaryTreeNode newBinaryTreeNode=new BinaryTreeNode();
            newBinaryTreeNode.left=newBinaryTreeNode.right=null;
            newBinaryTreeNode.data=serializedArray.get(low);
            System.out.println(newBinaryTreeNode.data);
            if (low==high) return newBinaryTreeNode;


            int partition=findPartition(low,high);
            newBinaryTreeNode.left=deSerializeFromRoot(low+1,partition-1);
            newBinaryTreeNode.right=deSerializeFromRoot(partition,high);
            return newBinaryTreeNode;
        }
        private int findPartition(int low,int high){
            int v=serializedArray.get(low);
            for(int i=low+1;i<=high;i++){
                if (v<serializedArray.get(i)) return i;
            }
            return -1;
        }
    }

