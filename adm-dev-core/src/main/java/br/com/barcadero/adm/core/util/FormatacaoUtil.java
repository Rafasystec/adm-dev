package br.com.barcadero.adm.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatacaoUtil {

	
	public static String telefoneComDDD(int ddd,long numero,boolean residencial){
		
		if(residencial){
			return "("+zerosLeft(ddd,2)+")"+zerosLeft(numero,8);
		}else{
			return "("+zerosLeft(ddd,2)+")"+zerosLeft(numero,9);
		}
	}
	
	
	public static String zerosLeft(String valor,int qtdCasas){
		String retorno =valor.toString();
		for(int i=valor.length();i<qtdCasas;++i){
			retorno="0"+retorno;
		}
		return retorno;
	}
	
	
	public static String zerosLeft(int valor,int qtdCasas){
		return zerosLeft(valor+"", qtdCasas);
	}
	
	public static String zerosLeft(long valor,int qtdCasas){
		return zerosLeft(valor+"", qtdCasas);
	}
	
	public static String dataPorExtenso(Date data){
		Locale local = new Locale("pt","BR");
		DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
		 return (formato.format(data));
	}

}
