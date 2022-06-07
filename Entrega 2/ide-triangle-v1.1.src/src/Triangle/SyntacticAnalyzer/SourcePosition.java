/*
 * @(#)SourcePosition.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;

public class SourcePosition {

  public int start[], finish[];

  public SourcePosition () {
    start = new int[2];
    finish = new int[2];
  }

  public SourcePosition (int s[], int f[]) {
    start = s;
    finish = f;
  }

  public String toString() {
    return "(" + start[0]+','+start[1] + ", " + finish[0]+','+ finish[1] + ")";
  }
}
