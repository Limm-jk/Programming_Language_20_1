package parser.ast;
import java.util.HashMap;
import java.util.Map;

import lexer.TokenType;

public class BinaryOpNode extends Node{
	public enum BinType { 
		MINUS 	{ TokenType tokenType() {return TokenType.MINUS;} }, 
		PLUS 	{ TokenType tokenType() {return TokenType.PLUS;} }, 
		TIMES 	{ TokenType tokenType() {return TokenType.TIMES;} }, 
		DIV 	{ TokenType tokenType() {return TokenType.DIV;} }, 
		LT 		{ TokenType tokenType() {return TokenType.LT;} }, 
		GT 		{ TokenType tokenType() {return TokenType.GT;} }, 
		EQ 		{ TokenType tokenType() {return TokenType.EQ;} };

		private static Map<TokenType, BinType> fromTokenType = new HashMap<TokenType, BinType>();
		
		static {
			for (BinType bType : BinType.values()){
				fromTokenType.put(bType.tokenType(), bType);
			}
		}
		
		static BinType getBinType(TokenType tType){
			return fromTokenType.get(tType);
		}
		
		abstract TokenType tokenType();
		
	}
	public BinType value;
	
	public void setValue(TokenType tType){
		BinType bType = BinType.getBinType(tType);
		value = bType;
	}
		
	@Override
	public String toString(){
		return value.name();
	}
}
