package edu.neu.csye6200.ca;

public class CARule {
	
	int[] ruleset = {0,1,0,1,1,0,1,0};
	
	int rules (int a, int b, int c) {
	    if      (a == 1 && b == 1 && c == 1) return ruleset[0];
	    else if (a == 1 && b == 1 && c == 0) return ruleset[1];
	    else if (a == 1 && b == 0 && c == 1) return ruleset[2];
	    else if (a == 1 && b == 0 && c == 0) return ruleset[3];
	    else if (a == 0 && b == 1 && c == 1) return ruleset[4];
	    else if (a == 0 && b == 1 && c == 0) return ruleset[5];
	    else if (a == 0 && b == 0 && c == 1) return ruleset[6];
	    else if (a == 0 && b == 0 && c == 0) return ruleset[7];
	    return 0;
	}

}
