class item():
    def __init__(self,setup_cost,incr_cost):
        self.setup_cost = setup_cost
        self.incr_cost  = incr_cost  

    def cost_per_unit(self,qty): 
         return ((self.setup_cost + (self.incr_cost * qty))) / qty

    def info(self):
        return "setup_cost: " + str(self.setup_cost) + "  incr: " + str(self.incr_cost)

part = item(1000,1)
    
def plot(part,qty):
    print("qty: " + str(qty) + " cost: " +   str(part.cost_per_unit(qty) ))


def slope(part,qty_1,qty_2):
    cost_1 = part.cost_per_unit(qty_1)
    cost_2 = part.cost_per_unit(qty_2)
    slope = (cost_2 - cost_1) / (qty_2 - qty_1)
    return slope 

def plot_slope(part,qty_1,qty_2):
    cost_1 = part.cost_per_unit(qty_1)
    cost_2 = part.cost_per_unit(qty_2)

    print ("qty_1: " + str(qty_1)  + " cost_1: " + str(cost_1) + 
           " qty_2: " + str(qty_2) + " cost_2: " + str(cost_2) + 
         " slope: " +  str(slope(part,qty_1,qty_2)))

def increment_pct(q1, q2):
    return (q2 - q1) / q1

# This is a poor man's first order  derivative 
def plot_delta_slope(part,qty_1):
    qty_2 = 1.1 * qty_1
    cost_1 = part.cost_per_unit(qty_1)
    cost_2 = part.cost_per_unit(qty_2)
    incr_pct = increment_pct(cost_1,cost_2)

    print ("qty_1: " + str(qty_1)  + " cost_1: " + str(cost_1) + 
           " qty_2: " + str(qty_2) + " cost_2: " + str(cost_2) + 
           " incr_pct " + str(incr_pct))
         #" slope: " +  str(slope(part,qty_1,qty_2)))
#plot (part,1)    
#plot (part,2)    
#plot (part,4)    
#plot (part,8)    
#plot (part,100)    
#plot (part,1000)    
#plot (part,10000)    
#plot (part,100000)    
#
#plot_slope(part,1,2)
#plot_slope(part,2,4)
#plot_slope(part,4,8)
#plot_slope(part,8,100)
#plot_slope(part,100,200)
#plot_slope(part,200,400)
#plot_slope(part,400,1000)
#plot_slope(part,1000,10000)
#plot_slope(part,1000,100000)
#plot_slope(part,1000,1000000)

plot_delta_slope(part,10)
plot_delta_slope(part,100)
plot_delta_slope(part,1000)
plot_delta_slope(part,10000)
plot_delta_slope(part,100000)
