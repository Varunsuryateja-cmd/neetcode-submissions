class TimeMap:

    def __init__(self):
        # Maps key -> list of [value, timestamp]
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.store.get(key, [])
        
        # Binary search
        left, right = 0, len(values) - 1
        while left <= right:
            mid = (left + right) // 2
            if values[mid][1] <= timestamp:
                res = values[mid][0]  # Valid candidate found, try looking for a closer larger timestamp on the right
                left = mid + 1
            else:
                right = mid - 1
                
        return res