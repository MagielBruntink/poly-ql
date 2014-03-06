// Implementation file for parser generated by fsyacc
module QlParser
#nowarn "64";; // turn off warnings that type variables used in production annotations are instantiated to concrete type
open Microsoft.FSharp.Text.Lexing
open Microsoft.FSharp.Text.Parsing.ParseHelpers
# 1 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
   
open System
open QL.Grammar
open Microsoft.FSharp.Collections   

# 12 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
// This type is the type of tokens accepted by the parser
type token = 
  | EOF
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
  | IF
  | BOOL_FALSE
  | BOOL_TRUE
  | QL_STRING
  | QL_MONEY
  | QL_INTEGER
  | QL_BOOLEAN
  | FORM
  | BOOL of (bool)
  | STRING of (string)
  | INT of (int)
  | ID of (string)
// This type is used to give symbolic names to token indexes, useful for error messages
type tokenId = 
    | TOKEN_EOF
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
    | TOKEN_IF
    | TOKEN_BOOL_FALSE
    | TOKEN_BOOL_TRUE
    | TOKEN_QL_STRING
    | TOKEN_QL_MONEY
    | TOKEN_QL_INTEGER
    | TOKEN_QL_BOOLEAN
    | TOKEN_FORM
    | TOKEN_BOOL
    | TOKEN_STRING
    | TOKEN_INT
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
// This type is used to give symbolic names to token indexes, useful for error messages
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_Statement_List
    | NONTERM_Statement
    | NONTERM_Question
    | NONTERM_QuestionType
    | NONTERM_Condition
    | NONTERM_Expression

// This function maps tokens to integers indexes
let tagOfToken (t:token) = 
  match t with
  | EOF  -> 0 
  | GREATER_EQUALS_THAN  -> 1 
  | LESS_EQUALS_THAN  -> 2 
  | GREATER_THAN  -> 3 
  | LESS_THAN  -> 4 
  | NOT  -> 5 
  | NOT_EQUALS  -> 6 
  | EQUALS  -> 7 
  | TIMES  -> 8 
  | DIVIDE  -> 9 
  | MINUS  -> 10 
  | PLUS  -> 11 
  | PARENS_CLOSE  -> 12 
  | PARENS_OPEN  -> 13 
  | BRACKET_CLOSE  -> 14 
  | BRACKET_OPEN  -> 15 
  | ASS  -> 16 
  | IF  -> 17 
  | BOOL_FALSE  -> 18 
  | BOOL_TRUE  -> 19 
  | QL_STRING  -> 20 
  | QL_MONEY  -> 21 
  | QL_INTEGER  -> 22 
  | QL_BOOLEAN  -> 23 
  | FORM  -> 24 
  | BOOL _ -> 25 
  | STRING _ -> 26 
  | INT _ -> 27 
  | ID _ -> 28 

// This function maps integers indexes to symbolic token ids
let tokenTagToTokenId (tokenIdx:int) = 
  match tokenIdx with
  | 0 -> TOKEN_EOF 
  | 1 -> TOKEN_GREATER_EQUALS_THAN 
  | 2 -> TOKEN_LESS_EQUALS_THAN 
  | 3 -> TOKEN_GREATER_THAN 
  | 4 -> TOKEN_LESS_THAN 
  | 5 -> TOKEN_NOT 
  | 6 -> TOKEN_NOT_EQUALS 
  | 7 -> TOKEN_EQUALS 
  | 8 -> TOKEN_TIMES 
  | 9 -> TOKEN_DIVIDE 
  | 10 -> TOKEN_MINUS 
  | 11 -> TOKEN_PLUS 
  | 12 -> TOKEN_PARENS_CLOSE 
  | 13 -> TOKEN_PARENS_OPEN 
  | 14 -> TOKEN_BRACKET_CLOSE 
  | 15 -> TOKEN_BRACKET_OPEN 
  | 16 -> TOKEN_ASS 
  | 17 -> TOKEN_IF 
  | 18 -> TOKEN_BOOL_FALSE 
  | 19 -> TOKEN_BOOL_TRUE 
  | 20 -> TOKEN_QL_STRING 
  | 21 -> TOKEN_QL_MONEY 
  | 22 -> TOKEN_QL_INTEGER 
  | 23 -> TOKEN_QL_BOOLEAN 
  | 24 -> TOKEN_FORM 
  | 25 -> TOKEN_BOOL 
  | 26 -> TOKEN_STRING 
  | 27 -> TOKEN_INT 
  | 28 -> TOKEN_ID 
  | 31 -> TOKEN_end_of_input
  | 29 -> TOKEN_error
  | _ -> failwith "tokenTagToTokenId: bad token"

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
let prodIdxToNonTerminal (prodIdx:int) = 
  match prodIdx with
    | 0 -> NONTERM__startstart 
    | 1 -> NONTERM_start 
    | 2 -> NONTERM_Statement_List 
    | 3 -> NONTERM_Statement_List 
    | 4 -> NONTERM_Statement_List 
    | 5 -> NONTERM_Statement 
    | 6 -> NONTERM_Statement 
    | 7 -> NONTERM_Question 
    | 8 -> NONTERM_QuestionType 
    | 9 -> NONTERM_QuestionType 
    | 10 -> NONTERM_QuestionType 
    | 11 -> NONTERM_QuestionType 
    | 12 -> NONTERM_Condition 
    | 13 -> NONTERM_Expression 
    | 14 -> NONTERM_Expression 
    | 15 -> NONTERM_Expression 
    | 16 -> NONTERM_Expression 
    | 17 -> NONTERM_Expression 
    | 18 -> NONTERM_Expression 
    | 19 -> NONTERM_Expression 
    | 20 -> NONTERM_Expression 
    | 21 -> NONTERM_Expression 
    | 22 -> NONTERM_Expression 
    | 23 -> NONTERM_Expression 
    | 24 -> NONTERM_Expression 
    | 25 -> NONTERM_Expression 
    | 26 -> NONTERM_Expression 
    | 27 -> NONTERM_Expression 
    | 28 -> NONTERM_Expression 
    | 29 -> NONTERM_Expression 
    | 30 -> NONTERM_Expression 
    | _ -> failwith "prodIdxToNonTerminal: bad production index"

let _fsyacc_endOfInputTag = 31 
let _fsyacc_tagOfErrorTerminal = 29

// This function gets the name of a token as a string
let token_to_string (t:token) = 
  match t with 
  | EOF  -> "EOF" 
  | GREATER_EQUALS_THAN  -> "GREATER_EQUALS_THAN" 
  | LESS_EQUALS_THAN  -> "LESS_EQUALS_THAN" 
  | GREATER_THAN  -> "GREATER_THAN" 
  | LESS_THAN  -> "LESS_THAN" 
  | NOT  -> "NOT" 
  | NOT_EQUALS  -> "NOT_EQUALS" 
  | EQUALS  -> "EQUALS" 
  | TIMES  -> "TIMES" 
  | DIVIDE  -> "DIVIDE" 
  | MINUS  -> "MINUS" 
  | PLUS  -> "PLUS" 
  | PARENS_CLOSE  -> "PARENS_CLOSE" 
  | PARENS_OPEN  -> "PARENS_OPEN" 
  | BRACKET_CLOSE  -> "BRACKET_CLOSE" 
  | BRACKET_OPEN  -> "BRACKET_OPEN" 
  | ASS  -> "ASS" 
  | IF  -> "IF" 
  | BOOL_FALSE  -> "BOOL_FALSE" 
  | BOOL_TRUE  -> "BOOL_TRUE" 
  | QL_STRING  -> "QL_STRING" 
  | QL_MONEY  -> "QL_MONEY" 
  | QL_INTEGER  -> "QL_INTEGER" 
  | QL_BOOLEAN  -> "QL_BOOLEAN" 
  | FORM  -> "FORM" 
  | BOOL _ -> "BOOL" 
  | STRING _ -> "STRING" 
  | INT _ -> "INT" 
  | ID _ -> "ID" 

// This function gets the data carried by a token as an object
let _fsyacc_dataOfToken (t:token) = 
  match t with 
  | EOF  -> (null : System.Object) 
  | GREATER_EQUALS_THAN  -> (null : System.Object) 
  | LESS_EQUALS_THAN  -> (null : System.Object) 
  | GREATER_THAN  -> (null : System.Object) 
  | LESS_THAN  -> (null : System.Object) 
  | NOT  -> (null : System.Object) 
  | NOT_EQUALS  -> (null : System.Object) 
  | EQUALS  -> (null : System.Object) 
  | TIMES  -> (null : System.Object) 
  | DIVIDE  -> (null : System.Object) 
  | MINUS  -> (null : System.Object) 
  | PLUS  -> (null : System.Object) 
  | PARENS_CLOSE  -> (null : System.Object) 
  | PARENS_OPEN  -> (null : System.Object) 
  | BRACKET_CLOSE  -> (null : System.Object) 
  | BRACKET_OPEN  -> (null : System.Object) 
  | ASS  -> (null : System.Object) 
  | IF  -> (null : System.Object) 
  | BOOL_FALSE  -> (null : System.Object) 
  | BOOL_TRUE  -> (null : System.Object) 
  | QL_STRING  -> (null : System.Object) 
  | QL_MONEY  -> (null : System.Object) 
  | QL_INTEGER  -> (null : System.Object) 
  | QL_BOOLEAN  -> (null : System.Object) 
  | FORM  -> (null : System.Object) 
  | BOOL _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | STRING _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | INT _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | ID _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
let _fsyacc_gotos = [| 0us; 65535us; 1us; 65535us; 0us; 1us; 3us; 65535us; 4us; 5us; 8us; 9us; 24us; 25us; 3us; 65535us; 4us; 8us; 8us; 8us; 24us; 8us; 3us; 65535us; 4us; 10us; 8us; 10us; 24us; 10us; 1us; 65535us; 14us; 15us; 3us; 65535us; 4us; 11us; 8us; 11us; 24us; 11us; 13us; 65535us; 21us; 22us; 27us; 28us; 36us; 37us; 48us; 38us; 49us; 39us; 50us; 40us; 51us; 41us; 52us; 42us; 53us; 43us; 54us; 44us; 55us; 45us; 56us; 46us; 57us; 47us; |]
let _fsyacc_sparseGotoTableRowOffsets = [|0us; 1us; 3us; 7us; 11us; 15us; 17us; 21us; |]
let _fsyacc_stateToProdIdxsTableElements = [| 1us; 0us; 1us; 0us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 1us; 2us; 3us; 4us; 1us; 4us; 1us; 5us; 1us; 6us; 1us; 7us; 1us; 7us; 1us; 7us; 1us; 7us; 1us; 8us; 1us; 9us; 1us; 10us; 1us; 11us; 1us; 12us; 1us; 12us; 11us; 12us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 1us; 12us; 1us; 12us; 1us; 12us; 1us; 12us; 1us; 13us; 11us; 13us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 1us; 13us; 1us; 14us; 1us; 15us; 1us; 16us; 1us; 17us; 1us; 18us; 1us; 19us; 1us; 20us; 11us; 20us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 25us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 26us; 26us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 27us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 28us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 29us; 30us; 11us; 21us; 22us; 23us; 24us; 25us; 26us; 27us; 28us; 29us; 30us; 30us; 1us; 21us; 1us; 22us; 1us; 23us; 1us; 24us; 1us; 25us; 1us; 26us; 1us; 27us; 1us; 28us; 1us; 29us; 1us; 30us; |]
let _fsyacc_stateToProdIdxsTableRowOffsets = [|0us; 2us; 4us; 6us; 8us; 10us; 12us; 14us; 16us; 19us; 21us; 23us; 25us; 27us; 29us; 31us; 33us; 35us; 37us; 39us; 41us; 43us; 45us; 57us; 59us; 61us; 63us; 65us; 67us; 79us; 81us; 83us; 85us; 87us; 89us; 91us; 93us; 95us; 107us; 119us; 131us; 143us; 155us; 167us; 179us; 191us; 203us; 215us; 227us; 229us; 231us; 233us; 235us; 237us; 239us; 241us; 243us; 245us; |]
let _fsyacc_action_rows = 58
let _fsyacc_actionTableElements = [|1us; 32768us; 24us; 2us; 0us; 49152us; 1us; 32768us; 28us; 3us; 1us; 32768us; 15us; 4us; 2us; 16386us; 17us; 20us; 28us; 12us; 1us; 32768us; 14us; 6us; 1us; 32768us; 0us; 7us; 0us; 16385us; 2us; 16386us; 17us; 20us; 28us; 12us; 0us; 16388us; 0us; 16389us; 0us; 16390us; 1us; 32768us; 16us; 13us; 1us; 32768us; 26us; 14us; 4us; 32768us; 20us; 19us; 21us; 18us; 22us; 17us; 23us; 16us; 0us; 16391us; 0us; 16392us; 0us; 16393us; 0us; 16394us; 0us; 16395us; 1us; 32768us; 13us; 21us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 11us; 32768us; 1us; 57us; 2us; 55us; 3us; 56us; 4us; 54us; 6us; 53us; 7us; 52us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 12us; 23us; 1us; 32768us; 15us; 24us; 2us; 16386us; 17us; 20us; 28us; 12us; 1us; 32768us; 14us; 26us; 0us; 16396us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 11us; 32768us; 1us; 57us; 2us; 55us; 3us; 56us; 4us; 54us; 6us; 53us; 7us; 52us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 12us; 29us; 0us; 16397us; 0us; 16398us; 0us; 16399us; 0us; 16400us; 0us; 16401us; 0us; 16402us; 0us; 16403us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 0us; 16404us; 2us; 16405us; 8us; 51us; 9us; 50us; 2us; 16406us; 8us; 51us; 9us; 50us; 0us; 16407us; 0us; 16408us; 4us; 16409us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 4us; 16410us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 4us; 16411us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 4us; 16412us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 4us; 16413us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 4us; 16414us; 8us; 51us; 9us; 50us; 10us; 49us; 11us; 48us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; 8us; 32768us; 5us; 36us; 13us; 27us; 18us; 35us; 19us; 34us; 25us; 32us; 26us; 33us; 27us; 31us; 28us; 30us; |]
let _fsyacc_actionTableRowOffsets = [|0us; 2us; 3us; 5us; 7us; 10us; 12us; 14us; 15us; 18us; 19us; 20us; 21us; 23us; 25us; 30us; 31us; 32us; 33us; 34us; 35us; 37us; 46us; 58us; 60us; 63us; 65us; 66us; 75us; 87us; 88us; 89us; 90us; 91us; 92us; 93us; 94us; 103us; 104us; 107us; 110us; 111us; 112us; 117us; 122us; 127us; 132us; 137us; 142us; 151us; 160us; 169us; 178us; 187us; 196us; 205us; 214us; 223us; |]
let _fsyacc_reductionSymbolCounts = [|1us; 6us; 0us; 1us; 2us; 1us; 1us; 4us; 1us; 1us; 1us; 1us; 7us; 3us; 1us; 1us; 1us; 1us; 1us; 1us; 2us; 3us; 3us; 3us; 3us; 3us; 3us; 3us; 3us; 3us; 3us; |]
let _fsyacc_productionToNonTerminalTable = [|0us; 1us; 2us; 2us; 2us; 3us; 3us; 4us; 5us; 5us; 5us; 5us; 6us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; 7us; |]
let _fsyacc_immediateActions = [|65535us; 49152us; 65535us; 65535us; 65535us; 65535us; 65535us; 16385us; 65535us; 16388us; 16389us; 16390us; 65535us; 65535us; 65535us; 16391us; 16392us; 16393us; 16394us; 16395us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 16396us; 65535us; 65535us; 16397us; 16398us; 16399us; 16400us; 16401us; 16402us; 16403us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; 65535us; |]
let _fsyacc_reductions ()  =    [| 
# 272 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : QL.Grammar.Form)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
                      raise (Microsoft.FSharp.Text.Parsing.Accept(Microsoft.FSharp.Core.Operators.box _1))
                   )
                 : '_startstart));
# 281 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _2 = (let data = parseState.GetInput(2) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _4 = (let data = parseState.GetInput(4) in (Microsoft.FSharp.Core.Operators.unbox data : 'Statement_List)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 54 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                  
                                                     {  Name = _2; 
                                                        StatementList = _4; }
                                                 
                   )
# 54 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : QL.Grammar.Form));
# 296 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 60 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                   [] 
                   )
# 60 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Statement_List));
# 306 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Statement)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 61 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                       [_1] 
                   )
# 61 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Statement_List));
# 317 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Statement)) in
            let _2 = (let data = parseState.GetInput(2) in (Microsoft.FSharp.Core.Operators.unbox data : 'Statement_List)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 62 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                   _1 :: _2 
                   )
# 62 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Statement_List));
# 329 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Question)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 65 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                   _1 
                   )
# 65 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Statement));
# 340 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Condition)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 66 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                _1 
                   )
# 66 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Statement));
# 351 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _4 = (let data = parseState.GetInput(4) in (Microsoft.FSharp.Core.Operators.unbox data : 'QuestionType)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 68 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                            Question(_1,_3,_4) 
                   )
# 68 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Question));
# 364 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 71 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                        QL_Boolean 
                   )
# 71 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'QuestionType));
# 374 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 72 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                          QL_Integer 
                   )
# 72 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'QuestionType));
# 384 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 73 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                        QL_Money 
                   )
# 73 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'QuestionType));
# 394 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 74 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                         QL_String 
                   )
# 74 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'QuestionType));
# 404 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _6 = (let data = parseState.GetInput(6) in (Microsoft.FSharp.Core.Operators.unbox data : 'Statement_List)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 76 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                                                                    Condition(_3,_6) 
                   )
# 76 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Condition));
# 416 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _2 = (let data = parseState.GetInput(2) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 79 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         _2 
                   )
# 79 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 427 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 80 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         Id(_1) 
                   )
# 80 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 438 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : int)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 81 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         LiteralStatement(Integer(_1)) 
                   )
# 81 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 449 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : bool)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 82 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         LiteralStatement(Boolean(_1)) 
                   )
# 82 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 460 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 83 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         LiteralStatement(String(_1)) 
                   )
# 83 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 471 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 84 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                      LiteralStatement(Boolean(true)) 
                   )
# 84 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 481 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 85 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         LiteralStatement(Boolean(false)) 
                   )
# 85 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 491 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _2 = (let data = parseState.GetInput(2) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 86 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                   Neg(_2) 
                   )
# 86 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 502 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 87 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                      ArithmicExpression(_1,Plus,_3) 
                   )
# 87 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 514 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 88 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         ArithmicExpression(_1,Minus,_3) 
                   )
# 88 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 526 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 89 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         ArithmicExpression(_1,Divide,_3) 
                   )
# 89 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 538 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 90 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         ArithmicExpression(_1,Times,_3) 
                   )
# 90 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 550 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 91 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,Equals,_3) 
                   )
# 91 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 562 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 92 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,NotEquals,_3) 
                   )
# 92 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 574 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 93 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,LessThan,_3) 
                   )
# 93 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 586 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 94 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,LessEqualsThan,_3) 
                   )
# 94 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 598 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 95 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,GreaterThan,_3) 
                   )
# 95 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
# 610 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : 'Expression)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 96 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                                                                         BinaryExpression(_1,GreaterEqualsThan,_3) 
                   )
# 96 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fsp"
                 : 'Expression));
|]
# 623 "C:\Users\p3pij_000\Documents\GitHub\poly-ql\PepijnVanDeKamp\QLGrammar\QLParsing\QlParser.fs"
let tables () : Microsoft.FSharp.Text.Parsing.Tables<_> = 
  { reductions= _fsyacc_reductions ();
    endOfInputTag = _fsyacc_endOfInputTag;
    tagOfToken = tagOfToken;
    dataOfToken = _fsyacc_dataOfToken; 
    actionTableElements = _fsyacc_actionTableElements;
    actionTableRowOffsets = _fsyacc_actionTableRowOffsets;
    stateToProdIdxsTableElements = _fsyacc_stateToProdIdxsTableElements;
    stateToProdIdxsTableRowOffsets = _fsyacc_stateToProdIdxsTableRowOffsets;
    reductionSymbolCounts = _fsyacc_reductionSymbolCounts;
    immediateActions = _fsyacc_immediateActions;
    gotos = _fsyacc_gotos;
    sparseGotoTableRowOffsets = _fsyacc_sparseGotoTableRowOffsets;
    tagOfErrorTerminal = _fsyacc_tagOfErrorTerminal;
    parseError = (fun (ctxt:Microsoft.FSharp.Text.Parsing.ParseErrorContext<_>) -> 
                              match parse_error_rich with 
                              | Some f -> f ctxt
                              | None -> parse_error ctxt.Message);
    numTerminals = 32;
    productionToNonTerminalTable = _fsyacc_productionToNonTerminalTable  }
let engine lexer lexbuf startState = (tables ()).Interpret(lexer, lexbuf, startState)
let start lexer lexbuf : QL.Grammar.Form =
    Microsoft.FSharp.Core.Operators.unbox ((tables ()).Interpret(lexer, lexbuf, 0))
