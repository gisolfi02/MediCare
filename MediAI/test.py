import unittest
from main import *


class BotTest(unittest.TestCase):
    def test_sintomo_vuoto(self):
        getSeverityDict()
        getDescription()
        getprecautionDict()
        getInfo()
        assert tree_to_code(classifier, columns, 1) == 0

    def test_sintomo_invalido(self):
        getSeverityDict()
        getDescription()
        getprecautionDict()
        getInfo()
        assert tree_to_code(classifier, columns, 1) == -1