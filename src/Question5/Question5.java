package Question5;

import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Question5{
	
	static boolean duplicates;
	
	
	public static void sortTime(Time[] timeArray) {
		for(int i =1; i< timeArray.length; i++) {
			for(int j = i; j>0; j--) {
				if(timeArray[j].compareTo(timeArray[j-1]) ==1) {
					break;
				}
				else if(timeArray[j].compareTo(timeArray[j-1]) == -1) {
					Time temp = timeArray[j];
					timeArray[j] = timeArray[j-1];
					timeArray[j-1] = temp;
				}
				else {
					duplicates = true;
					break;
				}
			}
		}
	}
	
	public static void printTime(Time[] timeArray) {
		for( int i = 0; i < timeArray.length; i++) {
			timeArray[i].print();
		}
		if (duplicates) {
			System.out.println("There Are Duplicates");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How Many Elements Of Time?: ");
		Random hour = new Random();
		Random minute = new Random();
		Random second = new Random();
		int size = input.nextInt();
		Time[] timeArray = new Time[size];
		for (int i = 0; i < size; i++) {
			timeArray[i] = new Time(hour.nextInt(23), minute.nextInt(59), second.nextInt(59));
		}
		
		sortTime(timeArray);
		printTime(timeArray);
		
		
	}
}


class Time implements Comparable<Time>{
	int hour;
	int minute;
	int second;
	
	public Time (int h, int m, int s) {
		this.hour = h;
		this.minute = m;
		this.second = s;
	}
	
	void print() {
		System.out.println(hour + ":" + minute +":" +second);
	}
	
	@Override
	public int compareTo(Time comp) {
		if (this.hour > comp.hour) {
			return 1;
		}
		else if (comp.hour > this.hour) {
			return -1;
		}
		else {
			if (this.minute > comp.minute) {
				return 1;
			}
			else if (comp.minute > this.minute) {
				return -1;
			}
			else {
				if (this.second > comp.second) {
					return 1;
				}
				else if (comp.second > this.second) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
	
}