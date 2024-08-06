class Solution(object):
    def minimumPushes(self, word):
        from collections import Counter
        freq=Counter(word)
        sorted_letters = sorted(freq.items(), key=lambda x: -x[1])

        key_press=0
        key_position =0
        press_per_key=[1]*8

        for letter,count in sorted_letters:
            key_index=key_position//8
            pres_count=(key_index%8)+1
            key_press += count * pres_count
            key_position += 1
      
        return key_press




