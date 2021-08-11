import java.util.*;
public class Main
{

  int i, j, k, digit,  q = 0;
  int[][] a = new int[9][9];
  int[] ar = new int[80];
  int[] ac = new int[80];
  int[] r2 = new int[80];
  int[] c2 = new int[80];
  Random r = new Random ();

  Scanner sc = new Scanner (System.in);
  void create ()
{
  
   

    int c = 0;
    while (c != 60)
    {
	int r1 = r.nextInt (9);
	int c1 = r.nextInt (9);
	if (c == 0)
	  {
	    
	    r2[q] = r1;
	    c2[q] = c1;
	    
	    int te = getRandom (9, r1, c1);
	    if (te != 0)
	      {
	
		a[r1][c1] = te;
		c++;
		q++;
	      }

	  }
	else
	  if (checkDuplicate (r1, c1) == 1)
	     

	  {
		
		r2[q] = r1;
		c2[q] = c1;
		
	int	te = getRandom (9, r1, c1);
		if (te != 0)
		  {
		    a[r1][c1] = te;
		    c++;
		    q++;
		  }

	      

	  }

 }





    int x = 0;
    for (i = 0; i < 9; i++)
      {
	for (j = 0; j < 9; j++)
	    {
	    if (a[i][j] != 0)
	      {
		ar[x] = i;
		ac[x] = j;
		
	
		x++;
	

	      }
	    }

      }



    display ();
  }

  public final int getRandom (int max, int i, int j)
  {
    int rand = (r.nextInt (max) + 1);
    int v = isvalid (i, j, rand);
    int va = isval (i, j, rand);
    if (v == 1 && va == 1)
      {
	
	return rand;
      }
    else
      return 0;
  }



  int checkDuplicate (int r1, int c1)
  {
    for (i = 0; i < r2.length; i++)
      {
	if (r2[i] == r1 && c2[i] == c1)
	  return 0;
      }
    return 1;
  }
  void display ()
  {
    for (i = 0; i < 9; i++)
      {
	for (j = 0; j < 9; j++)
	  {
	    if ((i % 3 == 0) && (j == 0))
	      System.out.println ("____________________________");
	    if (j % 3 == 0)
	      {
		System.out.print ("| " + " ");
	      }

	    System.out.print (a[i][j] + " ");

	  }

	System.out.println ("| " + "\n");


      }
    System.out.println ("____________________________");
  }

  void sudo ()
  {
    int t1, t2, t3, v, va, digit, r, roww, coll, count = 0,cerror=0;
    
    while (check()!=1)
{
	System.out.println ("Enter row and column respectively");
	roww = sc.nextInt ();
	coll = sc.nextInt ();
	i = roww;
	j = coll;
	int ans = questionChangeAttempt (roww, coll);

	if (ans == 1)
	  {

	    System.out.println ("\nEnter number");
	    digit = sc.nextInt ();

	   
	    v = isvalid (i, j, digit);
	    va = isval (i, j, digit);
	    a[i][j] = digit;
	    
	    if (!(v == 1 && va == 1) && (digit < 10 && digit > 0))
	      {
	          cerror++;
	
	//	a[i][j] = digit;
	//	System.out.println ("Correct");
		display ();
	      }
	   // else
	     // System.out.println ("Check again");
	  }
	else
	  System.out.println ("Question can't be altered");


      }
      if(cerror==0)
      System.out.println("Congratulations!!!!!!!!!!");
      else
      System.out.println(cerror+"Wrong");
      
    display ();
  }
int check()
{
    for(int p=0;p<9;p++)
    {
        for(int q=0;q<9;q++)
        {
            if(a[p][q]!=0)
            continue;
            else
            return 0;
        }
    }
    return 1;
}
  int isvalid (int ro, int co, int di)
  {
    int k = 9, c = co;
    co = 0;
    while (k != 0)
      {
	if ((a[ro][co] == di) && (co != c))
	  return 0;
	co++;
	k--;
      }
    return 1;
  }

  int isval (int g, int b, int dig)
  {
    int k = 9, r = g, c = b;
    g = 0;
    while (k != 0)
      {
	if ((a[g][b] == dig) && (g != r))
	  return 0;

	g++;
	k--;
      }
    return 1;
  }

  int questionChangeAttempt (int r, int c)
  {
    for (int t = 0; t < 60; t++)
      {
	if (ar[t] == r && ac[t] == c)
	{
	 
	  
	  return 0;
      }}
    return 1;
  }

  public static void main (String[]args)
  {
    Main s = new Main ();
    s.create ();

    s.sudo ();
}}


