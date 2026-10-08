class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        # Pair up position and speed for each car
        pair = [[p, s] for p, s in zip(position, speed)]
        
        # Sort cars in reverse order by position (closest to target first)
        pair.sort(reverse=True)
        
        stack = []
        for p, s in pair:
            # Time required for current car to reach target
            time = (target - p) / s
            stack.append(time)
            
            # If current car reaches target in <= time than the car in front,
            # it catches up and becomes part of that fleet (pop current car's time)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
                
        return len(stack)