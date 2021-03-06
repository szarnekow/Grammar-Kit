// ---- ExpressionParser.java -----------------
//header.txt
package org.intellij.grammar.expression;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.grammar.expression.ExpressionTypes.*;
import static org.intellij.grammar.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ExpressionParser implements PsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parse_only_(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parse_only_(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ARG_LIST) {
      result_ = arg_list(builder_, 0);
    }
    else if (root_ == ASSIGN_EXPR) {
      result_ = expr(builder_, 0, -1);
    }
    else if (root_ == BETWEEN_EXPR) {
      result_ = expr(builder_, 0, 2);
    }
    else if (root_ == CALL_EXPR) {
      result_ = expr(builder_, 0, 7);
    }
    else if (root_ == CONDITIONAL_EXPR) {
      result_ = expr(builder_, 0, 0);
    }
    else if (root_ == DIV_EXPR) {
      result_ = expr(builder_, 0, 3);
    }
    else if (root_ == ELVIS_EXPR) {
      result_ = expr(builder_, 0, 0);
    }
    else if (root_ == EXP_EXPR) {
      result_ = expr(builder_, 0, 5);
    }
    else if (root_ == EXPR) {
      result_ = expr(builder_, 0, -1);
    }
    else if (root_ == FACTORIAL_EXPR) {
      result_ = expr(builder_, 0, 6);
    }
    else if (root_ == IDENTIFIER) {
      result_ = identifier(builder_, 0);
    }
    else if (root_ == IS_NOT_EXPR) {
      result_ = expr(builder_, 0, 2);
    }
    else if (root_ == LITERAL_EXPR) {
      result_ = literal_expr(builder_, 0);
    }
    else if (root_ == MINUS_EXPR) {
      result_ = expr(builder_, 0, 1);
    }
    else if (root_ == MUL_EXPR) {
      result_ = expr(builder_, 0, 3);
    }
    else if (root_ == PAREN_EXPR) {
      result_ = paren_expr(builder_, 0);
    }
    else if (root_ == PLUS_EXPR) {
      result_ = expr(builder_, 0, 1);
    }
    else if (root_ == REF_EXPR) {
      result_ = expr(builder_, 0, 8);
    }
    else if (root_ == SPECIAL_EXPR) {
      result_ = special_expr(builder_, 0);
    }
    else if (root_ == UNARY_MIN_EXPR) {
      result_ = unary_min_expr(builder_, 0);
    }
    else if (root_ == UNARY_NOT_EXPR) {
      result_ = unary_not_expr(builder_, 0);
    }
    else if (root_ == UNARY_PLUS_EXPR) {
      result_ = unary_plus_expr(builder_, 0);
    }
    else if (root_ == XOR_EXPR) {
      result_ = expr(builder_, 0, 2);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return root(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ASSIGN_EXPR, BETWEEN_EXPR, CALL_EXPR, CONDITIONAL_EXPR,
      DIV_EXPR, ELVIS_EXPR, EXPR, EXP_EXPR,
      FACTORIAL_EXPR, IS_NOT_EXPR, LITERAL_EXPR, MINUS_EXPR,
      MUL_EXPR, PAREN_EXPR, PLUS_EXPR, REF_EXPR,
      SPECIAL_EXPR, UNARY_MIN_EXPR, UNARY_NOT_EXPR, UNARY_PLUS_EXPR,
      XOR_EXPR),
  };

  /* ********************************************************** */
  // '(' [ !')' expr  (',' expr) * ] ')'
  public static boolean arg_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<arg list>");
    result_ = consumeToken(builder_, "(");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, arg_list_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, ")") && result_;
    exit_section_(builder_, level_, marker_, ARG_LIST, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [ !')' expr  (',' expr) * ]
  private static boolean arg_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list_1")) return false;
    arg_list_1_0(builder_, level_ + 1);
    return true;
  }

  // !')' expr  (',' expr) *
  private static boolean arg_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list_1_0")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = arg_list_1_0_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr(builder_, level_ + 1, -1));
    result_ = pinned_ && arg_list_1_0_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  // !')'
  private static boolean arg_list_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !consumeToken(builder_, ")");
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // (',' expr) *
  private static boolean arg_list_1_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list_1_0_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!arg_list_1_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arg_list_1_0_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' expr
  private static boolean arg_list_1_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arg_list_1_0_2_0")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, ",");
    pinned_ = result_; // pin = 1
    result_ = result_ && expr(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // expr ';'?
  static boolean element(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = expr(builder_, level_ + 1, -1);
    result_ = result_ && element_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, element_recover_parser_);
    return result_;
  }

  // ';'?
  private static boolean element_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element_1")) return false;
    consumeToken(builder_, ";");
    return true;
  }

  /* ********************************************************** */
  // !('(' | '+' | '-' | '!' | 'multiply' | id | number)
  static boolean element_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !element_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // '(' | '+' | '-' | '!' | 'multiply' | id | number
  private static boolean element_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element_recover_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "(");
    if (!result_) result_ = consumeToken(builder_, "+");
    if (!result_) result_ = consumeToken(builder_, "-");
    if (!result_) result_ = consumeToken(builder_, "!");
    if (!result_) result_ = consumeToken(builder_, "multiply");
    if (!result_) result_ = consumeToken(builder_, ID);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // id
  public static boolean identifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, IDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // element *
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!element(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "root", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(assign_expr)
  // 1: BINARY(elvis_expr) BINARY(conditional_expr)
  // 2: BINARY(plus_expr) BINARY(minus_expr)
  // 3: BINARY(xor_expr) BINARY(between_expr) BINARY(is_not_expr)
  // 4: BINARY(mul_expr) BINARY(div_expr)
  // 5: PREFIX(unary_plus_expr) PREFIX(unary_min_expr) PREFIX(unary_not_expr)
  // 6: N_ARY(exp_expr)
  // 7: POSTFIX(factorial_expr)
  // 8: POSTFIX(call_expr)
  // 9: POSTFIX(ref_expr)
  // 10: ATOM(special_expr) ATOM(simple_ref_expr) ATOM(literal_expr) PREFIX(paren_expr)
  public static boolean expr(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expr")) return false;
    addVariant(builder_, "<expr>");
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expr>");
    result_ = unary_plus_expr(builder_, level_ + 1);
    if (!result_) result_ = unary_min_expr(builder_, level_ + 1);
    if (!result_) result_ = unary_not_expr(builder_, level_ + 1);
    if (!result_) result_ = special_expr(builder_, level_ + 1);
    if (!result_) result_ = simple_ref_expr(builder_, level_ + 1);
    if (!result_) result_ = literal_expr(builder_, level_ + 1);
    if (!result_) result_ = paren_expr(builder_, level_ + 1);
    pinned_ = result_;
    result_ = result_ && expr_0(builder_, level_ + 1, priority_);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean expr_0(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expr_0")) return false;
    boolean result_ = true;
    while (true) {
      Marker left_marker_ = left_marker_(builder_);
      if (!invalid_left_marker_guard_(builder_, left_marker_, "expr_0")) return false;
      Marker marker_ = builder_.mark();
      if (priority_ < 0 && consumeTokenSmart(builder_, "=")) {
        result_ = report_error_(builder_, expr(builder_, level_, -1));
        marker_.drop();
        left_marker_.precede().done(ASSIGN_EXPR);
      }
      else if (priority_ < 1 && consumeTokenSmart(builder_, "?")) {
        result_ = report_error_(builder_, expr(builder_, level_, 1));
        result_ = report_error_(builder_, elvis_expr_1(builder_, level_ + 1)) && result_;
        marker_.drop();
        left_marker_.precede().done(ELVIS_EXPR);
      }
      else if (priority_ < 1 && conditional_expr_0(builder_, level_ + 1)) {
        result_ = report_error_(builder_, expr(builder_, level_, 1));
        marker_.drop();
        left_marker_.precede().done(CONDITIONAL_EXPR);
      }
      else if (priority_ < 2 && consumeTokenSmart(builder_, "+")) {
        result_ = report_error_(builder_, expr(builder_, level_, 2));
        marker_.drop();
        left_marker_.precede().done(PLUS_EXPR);
      }
      else if (priority_ < 2 && consumeTokenSmart(builder_, "-")) {
        result_ = report_error_(builder_, expr(builder_, level_, 2));
        marker_.drop();
        left_marker_.precede().done(MINUS_EXPR);
      }
      else if (priority_ < 3 && consumeTokenSmart(builder_, "^")) {
        result_ = report_error_(builder_, expr(builder_, level_, 3));
        marker_.drop();
        left_marker_.precede().done(XOR_EXPR);
      }
      else if (priority_ < 3 && consumeTokenSmart(builder_, BETWEEN)) {
        result_ = report_error_(builder_, expr(builder_, level_, 3));
        result_ = report_error_(builder_, between_expr_1(builder_, level_ + 1)) && result_;
        marker_.drop();
        left_marker_.precede().done(BETWEEN_EXPR);
      }
      else if (priority_ < 3 && parseTokensSmart(builder_, 0, IS, NOT)) {
        result_ = report_error_(builder_, expr(builder_, level_, 3));
        marker_.drop();
        left_marker_.precede().done(IS_NOT_EXPR);
      }
      else if (priority_ < 4 && consumeTokenSmart(builder_, "*")) {
        result_ = report_error_(builder_, expr(builder_, level_, 4));
        marker_.drop();
        left_marker_.precede().done(MUL_EXPR);
      }
      else if (priority_ < 4 && consumeTokenSmart(builder_, "/")) {
        result_ = report_error_(builder_, expr(builder_, level_, 4));
        marker_.drop();
        left_marker_.precede().done(DIV_EXPR);
      }
      else if (priority_ < 7 && consumeTokenSmart(builder_, "!")) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(FACTORIAL_EXPR);
      }
      else if (priority_ < 6 && consumeTokenSmart(builder_, "**")) {
        while (true) {
          result_ = report_error_(builder_, expr(builder_, level_, 6));
          if (!consumeTokenSmart(builder_, "**")) break;
        }
        marker_.drop();
        left_marker_.precede().done(EXP_EXPR);
      }
      else if (priority_ < 8 && markerTypeIs(left_marker_, REF_EXPR) && arg_list(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(CALL_EXPR);
      }
      else if (priority_ < 9 && ref_expr_0(builder_, level_ + 1)) {
        result_ = true;
        marker_.drop();
        left_marker_.precede().done(REF_EXPR);
      }
      else {
        exit_section_(builder_, marker_, null, false);
        break;
      }
    }
    return result_;
  }

  // ':' expr
  private static boolean elvis_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elvis_expr_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ":");
    result_ = result_ && expr(builder_, level_ + 1, -1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '<' | '>' | '<=' | '>=' | '==' | '!='
  private static boolean conditional_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "conditional_expr_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokenSmart(builder_, "<");
    if (!result_) result_ = consumeTokenSmart(builder_, ">");
    if (!result_) result_ = consumeTokenSmart(builder_, "<=");
    if (!result_) result_ = consumeTokenSmart(builder_, ">=");
    if (!result_) result_ = consumeTokenSmart(builder_, "==");
    if (!result_) result_ = consumeTokenSmart(builder_, "!=");
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  public static boolean unary_plus_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_plus_expr")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeTokenSmart(builder_, "+");
    pinned_ = result_;
    result_ = pinned_ && expr(builder_, level_, 5);
    exit_section_(builder_, level_, marker_, UNARY_PLUS_EXPR, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean unary_min_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_min_expr")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeTokenSmart(builder_, "-");
    pinned_ = result_;
    result_ = pinned_ && expr(builder_, level_, 5);
    exit_section_(builder_, level_, marker_, UNARY_MIN_EXPR, result_, pinned_, null);
    return result_ || pinned_;
  }

  // AND add_group
  private static boolean between_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "between_expr_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AND);
    result_ = result_ && expr(builder_, level_ + 1, -2);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  public static boolean unary_not_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_not_expr")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeTokenSmart(builder_, "!");
    pinned_ = result_;
    result_ = pinned_ && expr(builder_, level_, 5);
    exit_section_(builder_, level_, marker_, UNARY_NOT_EXPR, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '.' identifier
  private static boolean ref_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ref_expr_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokenSmart(builder_, ".");
    result_ = result_ && identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // 'multiply' '(' simple_ref_expr ',' mul_expr ')'
  public static boolean special_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "special_expr")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<special expr>");
    result_ = consumeTokenSmart(builder_, "multiply");
    result_ = result_ && consumeToken(builder_, "(");
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, simple_ref_expr(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, ",")) && result_;
    result_ = pinned_ && report_error_(builder_, expr(builder_, level_ + 1, 3)) && result_;
    result_ = pinned_ && consumeToken(builder_, ")") && result_;
    exit_section_(builder_, level_, marker_, SPECIAL_EXPR, result_, pinned_, null);
    return result_ || pinned_;
  }

  // identifier
  public static boolean simple_ref_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simple_ref_expr")) return false;
    if (!nextTokenIsFast(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, REF_EXPR, result_);
    return result_;
  }

  // number
  public static boolean literal_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal_expr")) return false;
    if (!nextTokenIsFast(builder_, NUMBER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokenSmart(builder_, NUMBER);
    exit_section_(builder_, marker_, LITERAL_EXPR, result_);
    return result_;
  }

  public static boolean paren_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "paren_expr")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeTokenSmart(builder_, "(");
    pinned_ = result_;
    result_ = pinned_ && expr(builder_, level_, -1);
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, ")")) && result_;
    exit_section_(builder_, level_, marker_, PAREN_EXPR, result_, pinned_, null);
    return result_ || pinned_;
  }

  final static Parser element_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return element_recover(builder_, level_ + 1);
    }
  };
}