package com.andrew.binarysearchtree;

public class BinarySearchTree {
    public int Search_Node(int[] node,int index,int values)
    {
        if(index<node.length) {
            if(node[index] == values){
                return index;
            }else if(node[index] > values){
                return Search_Node(node, index * 2 + 1,values);
            }else if(node[index] < values){
                return Search_Node(node, index * 2 + 2,values);
            }
        }
        return -1;
    }
    public boolean Insert_Node(int[] node,int index,int values)
    {
        if(node[0] == 0) {
            node[0] = values;
            return true;
        }else{
            if (index < node.length) {
                if(node[index] == 0) {
                    node[index] = values;
                    return true;
                }else{
                    if (node[index] > values) {
                        return Insert_Node(node,index * 2 + 1,values);
                    } else if (node[index] < values) {
                        return Insert_Node(node,index * 2 + 2,values);
                    } else if (node[index] == values) {
                        return false;
                    }
                }
            }
            return false;
        }
    }
    private void Detele(int[] node,int index)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(node[left] == 0 && node[right] == 0){
            node[index] = 0;
        }else if(node[left] == 0){
            node[index] = node[right];
            node[right] = 0;
        }else if(node[right] == 0){
            node[index] = node[left];
            node[left] = 0;
        }else{
            while(node[right] != 0){
                node[index] = node[right];
                index = right;
                right = right * 2 + 2;
            }
            node[index] = 0;
        }
    }
    public boolean Delete_Node(int[] node,int index,int values)
    {
        if(index < node.length){
            if(node[index] == values){
                Detele(node,index);
                return true;
            }else{
                if(node[index] > values){
                    return Delete_Node(node,index * 2 + 1,values);
                }else{
                    return Delete_Node(node,index * 2 + 2,values);
                }
            }
        }else{
            return false;
        }
    }
    public String PreOrder(int[] node,int index)
    {
        String result = "";
        if(index < node.length){
            if(node[index] != 0) {
                result += "[" + String.valueOf(node[index]) + "]";
            }
            result += PreOrder(node,index * 2 + 1);
            result += PreOrder(node,index * 2 + 2);
        }
        return result;
    }
    public String InOrder(int[] node,int index)
    {
        String result = "";
        if(index < node.length){
            result += InOrder(node,index * 2 + 1);
            if(node[index] != 0) {
                result += "[" + String.valueOf(node[index]) + "]";
            }
            result += InOrder(node,index * 2 + 2);
        }
        return result;
    }
    public String PostOrder(int[] node,int index)
    {
        String result = "";
        if(index < node.length){
            result += PostOrder(node,index * 2 + 1);
            result += PostOrder(node,index * 2 + 2);
            if(node[index] != 0) {
                result += "[" + String.valueOf(node[index]) + "]";
            }
        }
        return result;
    }
    public void Clear_Node(int[] node)
    {
        for(int i=0;i<node.length;i++)
        {
            node[i] = 0;
        }
    }
    public StringBuilder Show_Node(int[] node)
    {
        StringBuilder str_build=new StringBuilder();
        for(int i=0;i<node.length;i++)
        {
            if(node[i] != 0)
            {
                str_build.append("Index: " + i + " Data: " + String.valueOf(node[i]) + "\r\n");
            }
        }
        return str_build;
    }
}
