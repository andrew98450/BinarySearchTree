#include "pch.h"
#include <iostream>
#include <vector>
#include <string>
using namespace std;
struct Node 
{
	string data = "";
};
bool Search_Tree(vector<Node> node, int value, int index)
{
	if (index < node.size())
	{
		if (atoi(node[index].data.c_str()) == value)
		{
			return true;
		}
		if (atoi(node[index].data.c_str()) > value)
		{
			return Search_Tree(node, value, index * 2 + 1);
		}
		else
		{
			return Search_Tree(node, value, index * 2 + 2);
		}
	}
	else
	{
		return false;
	}
}
void Show_Tree(vector<Node> nodes)
{
	cout << "Node Data:" << endl;
	for (int i = 0; i < nodes.size(); i++)
	{
		if (nodes[i].data != "0")
		{
			cout << "Index: " << i << " Data: " << nodes[i].data << endl;
		}
	}
}
bool Insert_Tree(vector<Node> &nodes, int index, string values)
{
	if (atoi(nodes[0].data.c_str()) == 0) 
	{
		nodes[0].data = values;
		return true;
	}
	else
	{
		if (index < nodes.size()) 
		{
			if (atoi(nodes[index].data.c_str()) == 0)
			{
				nodes[index].data = values;
				return true;
			}
			else
			{
				if (atoi(nodes[index].data.c_str()) > atoi(values.c_str()))
				{
					return Insert_Tree(nodes, index * 2 + 1, values);
				}
				else if (atoi(nodes[index].data.c_str()) < atoi(values.c_str()))
				{
					return Insert_Tree(nodes, index * 2 + 2, values);
				}
				else if(atoi(nodes[index].data.c_str()) == atoi(values.c_str()))
				{
					return false;
				}
			}
		}
		else 
		{
			return false;
		}
	}
}
string PreOrder(vector<Node> nodes, int index) {
	string result = "";
	if (index < nodes.size())
	{
		if (atoi(nodes[index].data.c_str()) != 0) 
		{
			result += "[" + nodes[index].data + "]";
		}
		result += PreOrder(nodes, index * 2 + 1);
		result += PreOrder(nodes, index * 2 + 2);
	}
	return result;
}
string InOrder(vector<Node> nodes, int index) {
	string result = "";
	if (index < nodes.size())
	{
		result += InOrder(nodes, index * 2 + 1);
		if (atoi(nodes[index].data.c_str()) != 0)
		{
			result += "[" + nodes[index].data + "]";
		}
		result += InOrder(nodes, index * 2 + 2);
	}
	return result;
}
string PostOrder(vector<Node> nodes, int index) {
	string result = "";
	if (index < nodes.size())
	{
		result += PostOrder(nodes, index * 2 + 1);
		result += PostOrder(nodes, index * 2 + 2);
		if (atoi(nodes[index].data.c_str()) != 0)
		{
			result += "[" + nodes[index].data + "]";
		}
	}
	return result;
}
void Clear_Tree(vector<Node> &nodes) 
{
	for (int i = 0; i < nodes.size(); i++) 
	{
		nodes[i].data = "0";
	}
}
int main()
{
	bool is_loop = true;
	vector<Node> nodes(200);
	Clear_Tree(nodes);
	string values = "";
	int choose_num = 0, search_value = 0;
	while (is_loop) {
		cout << "     BinarySearchTree     " << endl;
		cout << "==========================" << endl;
		cout << "1.Insert Node Value" << endl;
		cout << "2.PreOrder" << endl;
		cout << "3.InOrder" << endl;
		cout << "4.PostOrder" << endl;
		cout << "5.Search Node Value" << endl;
		cout << "6.Show Tree" << endl;
		cout << "7.Clear Tree" << endl;
		cout << "8.Exit" << endl;
		cout << "==========================" << endl;
		cout << "Enter Choose:";
		cin >> choose_num;
		switch (choose_num)
		{
		case 1:
			cout << "Enter Value:";
			cin >> values;
			if (Insert_Tree(nodes, 0, values) == true) 
			{
				cout << "Insert Value Node Success" << endl;
			}
			else 
			{
				cout << "Insert Value Node Fail" << endl;
			}
			break;
		case 2:
			cout << "PreOrder Result:  " << PreOrder(nodes, 0) << endl;
			break;
		case 3:
			cout << "InOrder Result:   " << InOrder(nodes, 0) << endl;
			break;
		case 4:
			cout << "PostOrder Result: " << PostOrder(nodes, 0) << endl;
			break;
		case 5:
			cout << "Enter Search Value:";
			cin >> search_value;
			if (Search_Tree(nodes, search_value, 0) == true)
			{
				cout << "Search Result: This Value is Found" << endl;
			}
			else
			{
				cout << "Search Result: This Value is Not Found" << endl;
			}
			break;
		case 6:
			Show_Tree(nodes);
			break;
		case 7:
			Clear_Tree(nodes);
			cout << "Cleared Nodes..." << endl;
			break;
		case 8:
			is_loop = false;
			break;
		default:
			cout << "Enter Value is Error" << endl;
			break;
		}
	}
}