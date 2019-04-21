package com.andrew.binarysearchtree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView insert_text,search_text,delete_text,order_text,view_text;
    EditText insert_edit,search_edit,delete_edit;
    Button add_bt,search_bt,delete_bt,preorder_bt,inordr_bt,postorder_bt,clear_bt,show_bt;
    final int[] nodes=new int[256];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert_text = (TextView)findViewById(R.id.insert_text);
        search_text = (TextView)findViewById(R.id.search_text);
        delete_text = (TextView)findViewById(R.id.delete_text);
        order_text = (TextView)findViewById(R.id.order_text);
        view_text = (TextView)findViewById(R.id.view_text);
        insert_edit = (EditText)findViewById(R.id.insert_edit);
        search_edit = (EditText)findViewById(R.id.search_edit);
        delete_edit = (EditText)findViewById(R.id.delete_edit);
        add_bt = (Button)findViewById(R.id.add_bt);
        search_bt = (Button)findViewById(R.id.search_bt);
        delete_bt = (Button)findViewById(R.id.delete_bt);
        preorder_bt = (Button)findViewById(R.id.preorder_bt);
        inordr_bt = (Button)findViewById(R.id.inorder_bt);
        postorder_bt = (Button)findViewById(R.id.postorder_bt);
        clear_bt = (Button)findViewById(R.id.clear_bt);
        show_bt = (Button)findViewById(R.id.show_bt);
        final BinarySearchTree BST = new BinarySearchTree();
        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert_edit.getText().toString().equals("") == false) {
                    int values = Integer.parseInt(insert_edit.getText().toString());
                    if(BST.Insert_Node(nodes, 0, values) == true){
                        insert_text.setText("Enter Value:" + "Insert Node Value Success");
                        insert_edit.setText("");
                    }else{
                        insert_text.setText("Enter Value:" + "Insert Node Value Fail");
                        insert_edit.setText("");
                    }
                }
            }
        });
        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_edit.getText().toString().equals("") == false) {
                    int values = Integer.parseInt(search_edit.getText().toString());
                    int result = BST.Search_Node(nodes, 0, values);
                    if(result != -1){
                        search_text.setText("Enter Search Value:" + "Node Value is Found In Index " + String.valueOf(result));
                    }else{
                        search_text.setText("Enter Search Value:" + "Node Value is Not Found");
                    }
                }
            }
        });
        delete_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delete_edit.getText().toString().equals("") == false) {
                    int values = Integer.parseInt(delete_edit.getText().toString());
                    if(BST.Delete_Node(nodes, 0, values) == true){
                        delete_text.setText("Enter Delete Value:" + "Delete Node Value Success");
                        delete_edit.setText("");
                    }else{
                        delete_text.setText("Enter Delete Value:" + "Delete Node Value Fail");
                        delete_edit.setText("");
                    }
                }
            }
        });
        preorder_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_text.setText("");
                order_text.append("PreOrder Result:"+"\r\n");
                order_text.append(BST.PreOrder(nodes,0));
            }
        });
        inordr_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_text.setText("");
                order_text.append("InOrder Result:"+"\r\n");
                order_text.append(BST.InOrder(nodes,0));
            }
        });
        postorder_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_text.setText("");
                order_text.append("PostOrder Result:"+"\r\n");
                order_text.append(BST.PostOrder(nodes,0));
            }
        });
        clear_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BST.Clear_Node(nodes);
                view_text.setText("Cleared All Nodes");
            }
        });
        show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str  = BST.Show_Node(nodes);
                view_text.setText(str.toString());
            }
        });
    }
}
