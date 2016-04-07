class County:
    NAME_START = 193
    NAME_END = 238
    def __init__(self, line):
        self.name = line[County.NAME_START:County.NAME_END]
