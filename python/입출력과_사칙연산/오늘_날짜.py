from datetime import datetime

now = datetime.now()
now_changed = now.strftime("%Y-%m-%d")
print(now_changed)