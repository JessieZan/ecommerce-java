package com.com.jessiezan.ecommerce.security;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EcommerceCrypto {

	public static String encrypt(String original) throws Exception{
		
		//Creating s Signature Object
		//Signature sign = Signature.getInstance("SHA256withRSA");
		
		//1 Criar um objeto do tipo KeyPairGenerator
		//KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
		
		//2 Escolho o tamanho da chave de criptografia
		//keyPair.initialize(2048);
		
		//3 Gero a chave
		//KeyPair pair = keyPair.generateKeyPair();
		String strMinhaChave = "123456789 123456789 123456789 12";
		Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");
		
		//3 Obtenho a chave publica a partir da chave gerada
		//PublicKey publicKey = pair.getPublic();
		
		//4 Escolho o algoritmo de criptografia
		Cipher cipher = Cipher.getInstance("AES");
		
		//5 Trabalho a transformação da nossa String
		cipher.init(Cipher.ENCRYPT_MODE , minhaChave);
		
		cipher.update(original.getBytes());
		
		//6 Gero a String criptografada
		String originalCripto = new String(cipher.doFinal(), "UTF-8");
		
		System.out.println("Debug = " + originalCripto);
		return originalCripto;
	}
}
