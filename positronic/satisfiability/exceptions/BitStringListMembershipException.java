package positronic.satisfiability.exceptions;

/**
 * <p>Title: BitStringListMembershipException</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListMembershipException extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public BitStringListMembershipException(String s)
  {
    super(s);
  }
}