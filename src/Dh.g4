grammar Dh;

code
: statement ';' code
| statement
| EOF
;

statement
: decl
| assign
| print
| loop
;

decl
: 'var' ID
;

assign
: ID '=' expr
;

/*loop
: 'yolo' '(' expr ')' '{' code '}'
;*/

loop
: 'yolo' expr 'times:' code 'endloop'
;

print
: 'pr' '(' expr ')'
;

expr
: atomExpr
| add
;

atomExpr
: ID
| INT
;

add
: atomExpr '+' expr
;

ID:	('a'..'z')+ ;
INT:	('0'..'9')+ ;
WS:	[ \n\t\r]+ -> skip ;
