class Solution:
    def encode(self, strs: list[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "#" + s
        return res

    def decode(self, s: str) -> list[str]:
        res = []
        i = 0

        while i < len(s):
            j = i
            # Find the position of the delimiter '#'
            while s[j] != "#":
                j += 1
            
            # Read the length of the upcoming string
            length = int(s[i:j])
            
            # Extract the original string using the parsed length
            res.append(s[j + 1 : j + 1 + length])
            
            # Move index past the current string
            i = j + 1 + length

        return res