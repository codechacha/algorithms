#include <iostream>

using namespace std;

typedef struct ListNode {
	int data;
	struct ListNode* next;
} ListNode;

int ListLength(struct ListNode* head) {
	int len = 0;
	struct ListNode* current = head;
	while (current!= NULL) 
	{
		len++;
		current = current->next;
	}
	return len;
}

void PrintList(struct ListNode* head) {
	struct ListNode* current = head;
	while (current != NULL)
	{
		cout << current->data << " -> ";
		current = current->next;
	}
	cout << "NULL\n";
}

void InsertInLinkedList(ListNode**head, int data, int position) {
	ListNode* inserted = new ListNode;
	inserted->data = data;
	
	if (position == 1 || *head == NULL) {
		inserted->next = *head;
		*head = inserted;
	}
	else {
		ListNode* inserted_prev = *head;
		for (int i = 1; (inserted_prev->next != NULL) && (i < position-1); i++) {
			inserted_prev = inserted_prev->next;
		}

		ListNode* inserted_next = inserted_prev->next;
		inserted_prev->next = inserted;
		inserted->next = inserted_next;
	}
}

void DeleteNodeFromLinkedList(ListNode** head, int position) {
	if (*head == NULL) {
		cout << "List empty" << "\n";
		return;
	}
	ListNode* removed_prev;
	ListNode* removed;
	if (position == 1) {
		removed = *head;
		*head = (*head)->next;
		delete(removed);
	}
	else {
		ListNode* removed_prev = *head;
		removed = removed_prev->next;
		for (int i = 1; (removed->next != NULL) && (i < position-1); i++) {
			removed_prev = removed_prev->next;
			removed = removed_prev->next;
		}
		removed_prev->next = removed->next;
		delete(removed);
	}
}



ListNode* head = NULL;

int main()
{
	InsertInLinkedList(&head, 4, 1);
	InsertInLinkedList(&head, 17, 1);
	InsertInLinkedList(&head, 1, 1);
	InsertInLinkedList(&head, 5, 1);

	PrintList(head);
	InsertInLinkedList(&head, 10, 1);
	PrintList(head);
	InsertInLinkedList(&head, 11, 3);
	PrintList(head);
	InsertInLinkedList(&head, 11, 9);
	PrintList(head);
	DeleteNodeFromLinkedList(&head, 1);
	PrintList(head);
	DeleteNodeFromLinkedList(&head, 3);
	PrintList(head);
	DeleteNodeFromLinkedList(&head, 10);
	PrintList(head);
}
