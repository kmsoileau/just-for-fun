package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
/**
 * <p>Title: NaturalNumberList</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberList extends BitStringList implements INaturalNumberList
{
  private INaturalNumber[] arrayN;
  private String name;
  private static int nNLCount;

  public NaturalNumberList(INaturalNumber[] data) throws Exception
    {
      this("NaturalNumberList$"+ nNLCount++,data);
    }

  public NaturalNumberList(long[] data) throws Exception
  {
    this("NaturalNumberList$"+ nNLCount++,data);
  }

  public NaturalNumberList(String name, INaturalNumber[] data) throws Exception
  {
  	if(name==null)
      throw new NaturalNumberListException("Passed null String to constructor.");
    if(data==null)
      throw new NaturalNumberListException("Passed null INaturalNumber[] to constructor.");
    this.name=name;
    this.arrayN=new INaturalNumber[data.length];
    for(int i=0;i<data.length;i++)
    {
      IBitString b=new BitString(name+"$"+i,data[i].getBVArray());
      this.arrayN[i]=new NaturalNumber(name+"$"+i,b);
    }
  }
  
  public NaturalNumberList(String name, long[] data) throws Exception
  {
  	if(name==null)
      throw new NaturalNumberListException("Passed null String to constructor.");
  	if(data==null)
      throw new NaturalNumberListException("Passed null long[] to constructor.");
    
    this.name=name;
    this.arrayN=new INaturalNumber[data.length];
    for(int i=0;i<this.arrayN.length;i++)
    {
    	//setNaturalNumber(i, data[i]);
      positronic.math.Number n=new positronic.math.Number(name,data[i]);
      n=new positronic.math.Number(n,NaturalNumber.getLength());
      boolean[] bool=n.getBitArray();
      IBitString ib=(IBitString)new BitString(name,bool);
      INaturalNumber inter=new NaturalNumber(name+"$"+i,ib);
      this.arrayN[i]=inter;
    }
  }

  public String getName()
  {
    return name;
  }

  public INaturalNumber getNaturalNumber(int i) throws NaturalNumberListException
  {
  	if(i<0 || i>this.size()-1)
  		throw new NaturalNumberListException("Attempted to index out of range in method getNaturalNumber.");
    return this.arrayN[i];
  }

  public INaturalNumber[] getNaturalNumberArray() 
  {
	  return this.arrayN; 
  }

  public void setName(String name) throws NaturalNumberListException
  {
  	if(name==null)
  		throw new NaturalNumberListException("Passed a null String to method setName.");
    
    this.name = name;
  }

  public void setNaturalNumber(int i,INaturalNumber naturalNumber) throws NaturalNumberListException
  {
  	if(i<0 || i>this.size()-1)
  		throw new NaturalNumberListException("Attempted to index out of range in method getNaturalNumber.");
    if(naturalNumber==null)
  		throw new NaturalNumberListException("Passed a null INaturalNumber to method setNaturalNumber.");
    
    this.arrayN[i]=naturalNumber;
  }

  public void setNaturalNumber(int index, long data) throws Exception
  {
  	if(index<0 || index>this.size())
      throw new NaturalNumberListException("Attempted to index out of range.");
  	if(data<0L)
      throw new NaturalNumberListException("Passed negative long to constructor.");
    
    positronic.math.Number n=new positronic.math.Number(this.getName(),data);
    n=new positronic.math.Number(n,NaturalNumber.getLength());
    boolean[] bool=n.getBitArray();
    IBitString ib=(IBitString)new BitString(name,bool);
    this.arrayN[index]= new NaturalNumber(this.getName()+"$"+index,ib);
  }

  public int size()
  {
    return this.arrayN.length;
  }

  public String toString()
  {
    String res="$";
    if(this.size()>0)
    {
      try
			{
				res+=this.getNaturalNumber(0).toString();
			} catch (NaturalNumberListException e)
			{
				e.printStackTrace();
			}
      for(int i=1;i<this.size();i++)
				try
				{
					res+=","+this.getNaturalNumber(i);
				} catch (NaturalNumberListException e)
				{
					e.printStackTrace();
				}
    }
    return res+"$";
  }
}