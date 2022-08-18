class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        counts = dict()
        for num in arr:
            if (num not in counts):
                counts[num] = 1
            else:
                counts[num] += 1
        halfLength = len(arr) / 2
        curLength = len(arr)
        ans = 0
        count_list = list()
        for num in counts:
            count_list.append(counts[num])
        count_list = sorted(count_list, reverse = True)
        for num in count_list:
            curLength -= num
            ans += 1
            if (curLength <= halfLength):
                break
            
        
        return ans
