Software Engineering Lab 2

Name: BRANKO
Index: 225080

searchBookByTitle                                                          searchBook















<img width="566" height="821" alt="image" src="https://github.com/user-attachments/assets/e504a923-2ff4-4e0c-89d8-536e7b8b1e26" />  <img width="501" height="681" alt="image" src="https://github.com/user-attachments/assets/2c7414cf-6f75-4d7b-96ef-977173236264" />














Cyclomatic Complexity
 searchBookByTitle
    • Number of decision points (P): 4 
    • Cyclomatic Complexity: V(G) = P + 1 = 5

borrowBook
    • Number of decision points (P): 4 
    • Cyclomatic Complexity: V(G) = P + 1 = 5 

Every Statement – searchBookByTitle
The Every Statement criterion is satisfied when each statement in the function is executed at least once.
Test cases used:
    1. Input is an empty string → triggers IllegalArgumentException. 
    2. Book with matching title exists and is not borrowed → returns a non-empty list. 
    3. No book with the given title exists → function returns null. 
These test cases ensure that all statements are executed, including exception handling, loop execution, successful addition to results, and the empty result check.
Every Branch – borrowBook
The Every Branch criterion ensures that each decision branch in the function is executed at least once.
Branches covered:
    1. Invalid input branch (empty title or author) → throws IllegalArgumentException. 
    2. Successful borrow branch (book exists and is not borrowed). 
    3. Book already borrowed branch → throws RuntimeException. 
    4. Book not found branch → throws RuntimeException. 
Each branch in the decision structure is tested, including validation, matching logic, and error handling paths.

Multiple Condition – borrowBook and searchBookByTitle
The Multiple Condition criterion ensures all combinations of boolean sub-conditions are tested.
For borrowBook(title.isEmpty() || author.isEmpty()):
    • TT → both inputs empty → exception thrown 
    • TF → title empty, author valid → exception thrown 
    • FT → title valid, author empty → exception thrown 
    • FF → both valid → execution continues to search logic 

For searchBookByTitle(book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()):
    • TT → matching title and not borrowed → book added to results 
    • TF → matching title but already borrowed → skipped 
    • FT → non-matching title → skipped 
    • FF → non-matching title and borrowed → skipped 
All combinations of sub-conditions are covered to ensure full logical coverage.





