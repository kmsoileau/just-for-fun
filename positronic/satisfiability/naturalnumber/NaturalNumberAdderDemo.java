/*
 * NaturalNumberAdderDemo.java	1.0 05/05/04
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */
 /**
 * <p>Title: NaturalNumberAdderDemo</p>
 * <p>Description: A demonstration of the use of the NaturalNumberAdder
 * object.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberAdderDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    INaturalNumber Z=new NaturalNumber("Z");
    INaturalNumber C=new NaturalNumber("C");

    NaturalNumberFixer bnnfx=new NaturalNumberFixer(X,127);
    NaturalNumberFixer bnnfy=new NaturalNumberFixer(Y,121);

    NaturalNumberAdder NaturalNumberAdder1 = new NaturalNumberAdder(X,Y,Z,C);

    IProblem p=new Conjunction(new Conjunction(bnnfx,bnnfy),NaturalNumberAdder1);

    System.out.println(p);
    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("X = "+X);
      System.out.println("Y = "+Y);
      System.out.println("Z = "+Z);
      System.out.println("C = "+C);
    }
		else
      System.out.println("No solution.");
  }
}