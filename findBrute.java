/*
 *Returns the lowest index at which substring pattern beigns *in text (or els -1).
 */

private static int findBrute(List<Character> text, List<Character> pattern)
{
	int n = n = text.size();
	int m = pattern.size();
	for (int i = 0; i <= n - m; i++)
	{
		//try every starting index within text
		int k = 0; // k is index into pattern
		while(k < m && text.get(i + k) == patter.get(k))
		//kth character of pattern matches
		k++;
		if (k == m) // if we reach the end of the pattern
		{
			return i; // substring text[i .. m+i] is a match
		}
		return -1; // search failed
	}
}