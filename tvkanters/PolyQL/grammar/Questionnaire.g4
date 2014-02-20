grammar Questionnaire;

@header {
    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.model.*;
    import nl.uva.polyql.model.expressions.*;
}


form returns [Form f]
	@init { $f = new Form(); } :
	'form' ID '{' (r = formrule[$f])+ '}';

formrule[RuleContainer rc] : 
	field[$rc] | question[$rc] | ifstatement[$rc];
	
field[RuleContainer rc] : 
	id=ID ':' content=STRING type=TYPE'(' e=expr_comp_bool[$rc] ')' { $rc.addField($id.text, $content.text, $type.text, $e.e); };

question[RuleContainer rc] : 
	id=ID ':' content=STRING type=TYPE { $rc.addQuestion($id.text, $content.text, $type.text); };

ifstatement[RuleContainer rc] : 
	'if' '(' e=expr_comp_bool[$rc] { $rc.addIfStatement($e.e); } ')' '{' (r = formrule[$rc])+ '}';

expr_comp_bool[RuleContainer rc] returns [Expression e] :
	(left=expr_comp_num[$rc]{$e = $left.e;}) (op=OP_COMP_BOOL right=expr_comp_num[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);} )* ;

expr_comp_num[RuleContainer rc] returns [Expression e] :
	(left=expr_sum[$rc]{$e = $left.e;}) (op=OP_COMP_NUM right=expr_sum[$rc]{$e = new BooleanOperation($e, $op.text, $right.e);} )* ;

expr_sum[RuleContainer rc] returns [Expression e] :
	(left=expr_prod[$rc]{$e = $left.e;}) (op=OP_SUM right=expr_prod[$rc]{$e = new NumberOperation($e, $op.text, $right.e);} )* ;

expr_prod[RuleContainer rc] returns [Expression e] :
	(left=expr_atom[$rc]{$e = $left.e;}) (op=OP_PROD right=expr_atom[$rc]{$e = new NumberOperation($e, $op.text, $right.e);} )* ;

expr_atom[RuleContainer rc] returns [Expression e] :
	mod=MODIFIER?ID { $e = new IdAtom($rc, $ID.text, $mod.text); }
	| NUMBER { $e = new NumberAtom($NUMBER.text); }
	| '(' expr=expr_comp_bool[$rc]{ $e = $expr.e; } ')' ;



OP_COMP_BOOL : ('=='|'!='|'&&'|'||');
OP_COMP_NUM : ('<'|'>'|'>='|'<=');
OP_SUM : ('+'|'-');
OP_PROD : ('*'|'/');
MODIFIER : ('!'|'-');

TYPE : ('boolean'|'number');
ID : LETTER (LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '"';
LETTER : ('a'..'z'|'A'..'Z');
NUMBER : '-'?DIGIT+('.'DIGIT+)?;
DIGIT : ('0'..'9');
WS : (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' ');
