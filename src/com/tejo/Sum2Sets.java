package com.tejo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2Sets {
	
	private Map<Integer,List<Integer>> sum2sets = new HashMap<Integer, List<Integer>>();
    private int n;
    private int max;
    private int[] theSet;

    public Sum2Sets( int[] theSet ){
        this.theSet = theSet;
        int n = theSet.length;
        max = (1 << n) - 1;
        int maxSum = n*(n+1)/2;
    }
    private int sum( int n ){
        int s = 0;
        for( int i = 0; n > 0; i++ ){
            if( (n & 1) != 0 ) s += theSet[i];
            n = n >> 1;
        }
        return s;
    }
    public String setAsString( int n ){
        StringBuilder sb = new StringBuilder( "[" );
        String del = "";
        for( int i = 0; n > 0; i++ ){
            if( (n & 1) != 0 ){
                sb.append( del ).append( theSet[i] );
                del = ", ";
            }
            n = n >> 1;
        }
        sb.append( "]" );
        return sb.toString();
    }
    public void dumpAll( int n ){
        for( Map.Entry<Integer,List<Integer>> e: sum2sets.entrySet() ){
        	
            int sum = e.getKey();
            //if(n != sum)continue;
            List<Integer> sets = e.getValue();
            if( sets.size() >= 2 ){
                System.out.println( "sum: " + sum );
                for( Integer i: sets ){
                    System.out.print( " " + setAsString( i ) );
                }
                System.out.println();
                if( --n == 0 ) break;
            }
            break;
        }
    }
    public void buildLists(){
        int maxlen = 0;
        int maxsum = 0;
        for( int i = 0; i <= max; i++ ){
           int s = sum( i );
            List<Integer> set = sum2sets.get( s );
            if( set == null ){
            set = new ArrayList<Integer>();
                sum2sets.put( s, set );
            }
            set.add( i );
            int len = sum2sets.size();
            if( len > maxlen ){
                maxsum = s;
                maxlen = len;
            }
        }
        System.out.println( "max. len " + maxlen + " at " + maxsum );
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{
		         3,   7, 13, 18, 21, 22, 30, 34, 42, 49,
		         50, 61, 65, 67, 70, 71, 88, 91, 93, 99 };
		int[] nums2 = new int[]{
		         10, 20, 30, 40, 90, 100, 110,200 };
			Sum2Sets sum = new Sum2Sets( nums2 );
		    sum.buildLists();
		    sum.dumpAll( 50 );
		}
	}


