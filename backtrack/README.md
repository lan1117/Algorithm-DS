Backtracking can be solved always as follows:
while(Problem is not solved)
  For each path from the starting point.
    chick if selected path is safe, if yes select it and make recursive call to rest of the problem before whilch undo the current move.
  End for
if none of the move works out, return false, NO SOLUTION.
