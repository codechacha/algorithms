#include "pch.h"
#include <iostream>

using namespace std;

typedef struct ListNode {
    int data;
    struct ListNode* next;
    struct ListNode* prev;
} ListNode;

void PrintList(struct ListNode* head) {
    ListNode* current = head;
    while (current != NULL) {
        cout << current->data << " -> ";
        current = current->next;
    }
    cout << "NULL\n";
}

void DLLInsert(ListNode **head, int data, int position) {
    ListNode *inserted = new ListNode;
    inserted->data = data;
    if (*head == NULL || position == 1) {
        inserted->prev = NULL;
        inserted->next = *head;
        if (*head != NULL) {
            (*head)->prev = inserted;
        }
        *head = inserted;
    } else {
        ListNode *inserted_prev = *head;
        ListNode *inserted_next;
        for (int i = 1; i < (position-1) && inserted_prev->next != NULL; i++) {
            inserted_prev = inserted_prev->next;
        }

        inserted_next = inserted_prev->next;
        if (inserted_next == NULL) { // last item
            inserted_prev->next = inserted;
            inserted->prev = inserted_prev;
            inserted->next = NULL;
        }
        else {
            inserted_prev->next = inserted;
            inserted_next->prev = inserted;
            inserted->prev = inserted_prev;
            inserted->next = inserted_next;
        }
    }
}

void DLLDelete(ListNode **head, int position) {
    if (*head == NULL) {
        return;
    }

    ListNode *removed;
    ListNode *removed_next;
    ListNode *removed_prev;
    if (position == 1) {
        removed = *head;
        *head = (*head)->next;
        (*head)->prev = NULL;
        delete removed;
    }
    else {
        removed = *head;
        for (int i = 1; i < position && removed->next != NULL; i++) {
            removed = removed->next;
        }

        removed_next = removed->next;
        removed_prev = removed->prev;
        if (removed_next == NULL) { // last item
            removed_prev->next = NULL;
            delete removed;
        }
        else {
            removed_prev->next = removed_next;
            removed_next->prev = removed_prev;
            delete removed;
        }
    }
}

ListNode *head = NULL;

int main()
{
    DLLInsert(&head, 4, 1);
    PrintList(head);
    DLLInsert(&head, 10, 1);
    PrintList(head);
    DLLInsert(&head, 15, 2);
    PrintList(head);
    DLLInsert(&head, 13, 2);
    PrintList(head);
    DLLInsert(&head, 13, 10);
    PrintList(head);
    
    DLLDelete(&head, 1);
    PrintList(head);
    DLLDelete(&head, 10);
    PrintList(head);
    DLLDelete(&head, 2);
    PrintList(head);
}