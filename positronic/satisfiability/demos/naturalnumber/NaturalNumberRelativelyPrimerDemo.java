package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberRelativelyPrimer;

public class NaturalNumberRelativelyPrimerDemo
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumber M=new NaturalNumber();
		INaturalNumber N=new NaturalNumber();
		
		IProblem problem=new Conjunction(new IProblem[]{
				new NaturalNumberFixer(M,21),
				new NaturalNumberFixer(N,35),
				new NaturalNumberRelativelyPrimer(M,N)});
		
		System.out.println(problem);
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.print("\nM = "+M);
			System.out.print("\tN = "+N);
		}
		else
			System.out.println("No solution.");
	}
}