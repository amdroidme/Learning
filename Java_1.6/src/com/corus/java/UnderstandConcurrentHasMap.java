package com.corus.java;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class UnderstandConcurrentHasMap {
	public static void main(String[] args) {










		UnderstandConcurrentHasMap understandConcurrentHasMap = new UnderstandConcurrentHasMap();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ThreadHashMap hashMap2 = understandConcurrentHasMap.new ThreadHashMap(hashMap);
		ThreadHashMap1 hashMap1 = understandConcurrentHasMap.new ThreadHashMap1(hashMap);
		ThreadHashMap hashMap3 = understandConcurrentHasMap.new ThreadHashMap(hashMap);
		ThreadHashMap hashMap4 = understandConcurrentHasMap.new ThreadHashMap(hashMap);
		
		hashMap1.start();
		hashMap2.start();
		hashMap3.start();
		hashMap4.start();
		
		hashMap1.start();
		hashMap2.start();
		hashMap3.start();
		hashMap4.start();
		
		
	}

	class ThreadHashMap extends Thread {
		HashMap<String, String> map = null;
		public ThreadHashMap(HashMap<String, String> map) {
			this.map = map;
		}
		
		int count = 0;
		
		@Override
		public void run() {
			while(true) {
				System.out.println("Putting" + Thread.currentThread().getName() + "--- " + map.size());
			map.put(++count + System.currentTimeMillis()+ "asdfasgd", "testing");
			map.clear();
		}
			
		}
	}
	
	class ThreadHashMap1 extends Thread {
		HashMap<String, String> map = null;
		public ThreadHashMap1(HashMap<String, String> map) {
			this.map = map;
		}
		@Override
		public void run() {
			while(true) {
			map.put(new Random(200)+"asdfasgd", "testing");
			System.out.println("Putting" + Thread.currentThread().getName() + "--- " + map.size());
			}
		}
	}
	
}
