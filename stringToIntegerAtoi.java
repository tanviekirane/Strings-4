// constant time algo
class Solution {
    public int myAtoi(String s) {
        if(s == null) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        char first = s.charAt(0);
        char sign = '+';
        // take care of first char +
        if(first == '-'){
            sign = '-';
        }
        
        if(first != '+' && first != '-' && !Character.isDigit(first)) return 0;
        
        int result = 0; int limit = Integer.MAX_VALUE/10;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                if(sign == '+'){
                    if(result == limit){
                        if(c-'0' > 7){
                            return Integer.MAX_VALUE;
                        }
                    } else if(result > limit){
                        return Integer.MAX_VALUE;
                    }
                } else{
                    if(result == limit){
                        if(c-'0' > 8){
                            return Integer.MIN_VALUE;
                        } 
                    } else if(result > limit){
                        return Integer.MIN_VALUE;
                    }
                } 
                result = result *10 + (c-'0');
            } else if(i != 0){
                break;
            }  
        }
        if(sign == '-') return -result;
        return result;
    }
}
