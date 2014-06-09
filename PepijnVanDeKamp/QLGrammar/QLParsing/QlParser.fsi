// Signature file for parser generated by fsyacc
module QlParser
type token = 
  | EOF
  | OR
  | AND
  | GREATER_EQUALS_THAN
  | LESS_EQUALS_THAN
  | GREATER_THAN
  | LESS_THAN
  | NOT
  | NOT_EQUALS
  | EQUALS
  | TIMES
  | DIVIDE
  | MINUS
  | PLUS
  | PARENS_CLOSE
  | PARENS_OPEN
  | BRACKET_CLOSE
  | BRACKET_OPEN
  | ASS
  | ELSE
  | IF
  | BOOL_FALSE
  | BOOL_TRUE
  | QL_STRING
  | QL_INTEGER
  | QL_BOOLEAN
  | FORM
  | BOOL of (bool)
  | STRING of (string)
  | INT of (int)
  | ID of (string)
type tokenId = 
    | TOKEN_EOF
    | TOKEN_OR
    | TOKEN_AND
    | TOKEN_GREATER_EQUALS_THAN
    | TOKEN_LESS_EQUALS_THAN
    | TOKEN_GREATER_THAN
    | TOKEN_LESS_THAN
    | TOKEN_NOT
    | TOKEN_NOT_EQUALS
    | TOKEN_EQUALS
    | TOKEN_TIMES
    | TOKEN_DIVIDE
    | TOKEN_MINUS
    | TOKEN_PLUS
    | TOKEN_PARENS_CLOSE
    | TOKEN_PARENS_OPEN
    | TOKEN_BRACKET_CLOSE
    | TOKEN_BRACKET_OPEN
    | TOKEN_ASS
    | TOKEN_ELSE
    | TOKEN_IF
    | TOKEN_BOOL_FALSE
    | TOKEN_BOOL_TRUE
    | TOKEN_QL_STRING
    | TOKEN_QL_INTEGER
    | TOKEN_QL_BOOLEAN
    | TOKEN_FORM
    | TOKEN_BOOL
    | TOKEN_STRING
    | TOKEN_INT
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
type nonTerminalId = 
    | NONTERM__startstartexpression
    | NONTERM__startstartstatement
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_startstatement
    | NONTERM_startexpression
    | NONTERM_Statement_List
    | NONTERM_Statement
    | NONTERM_Question
    | NONTERM_QuestionType
    | NONTERM_Condition
    | NONTERM_Expression
/// This function maps integers indexes to symbolic token ids
val tagOfToken: token -> int

/// This function maps integers indexes to symbolic token ids
val tokenTagToTokenId: int -> tokenId

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
val prodIdxToNonTerminal: int -> nonTerminalId

/// This function gets the name of a token as a string
val token_to_string: token -> string
val startexpression : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (QL.AbstractSyntaxTree.Expression) 
val startstatement : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (QL.AbstractSyntaxTree.Statement) 
val start : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (QL.AbstractSyntaxTree.Form) 
